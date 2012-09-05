/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-server Messages.java 2012-7-17 11:33:02 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.rebirth.commons.component.AbstractLifecycleComponent;
import cn.com.rebirth.commons.exception.RebirthException;
import cn.com.rebirth.commons.settings.Settings;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * The Class Messages.
 *
 * @author l.xue.nong
 */
public class Messages extends AbstractLifecycleComponent<Messages> {

	public Messages(Settings settings) {
		super(settings);
		this.max_retry = this.componentSettings.getAsInt("max_retry", 5);
		this.punish_time_step = this.componentSettings.getAsLong("punish_time_step", 500L);
	}

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(Messages.class);

	/** The Constant MAX_RETRY. */
	private final int max_retry;//最多允许一条消息重复投递5次

	/** The Constant PUNISH_TIME_STEP. */
	private final long punish_time_step;//每次重复投递的惩罚时间步长

	/** The subscription relationships. */
	private static Map<Class<?>, Set<MessageSubscriber>> subscriptionRelationships = Maps.newHashMap();//订阅关系网

	/** The punish post ring. */
	private static Ring<Wrapper> punishPostRing = new Ring<Wrapper>();//惩罚投递环

	/**
	 * The Class Wrapper.
	 *
	 * @author l.xue.nong
	 */
	private static class Wrapper {

		/** The message. */
		private final Message<?> message; //消息

		/** The expirt. */
		private final long expirt; //到期时间

		/**
		 * Instantiates a new wrapper.
		 *
		 * @param message the message
		 * @param expirt the expirt
		 */
		public Wrapper(Message<?> message, long expirt) {
			this.message = message;
			this.expirt = expirt;
		}

	}

	/** The deamon. */
	private Thread deamon = new Thread("message-punish-deamon") {

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(500);
					if (punishPostRing.isEmpty()) {
						continue;
					}
					final long now = System.currentTimeMillis();
					Iterator<Wrapper> it = punishPostRing.iterator();
					while (it.hasNext()) {
						Wrapper wrapper = it.next();
						if (now < wrapper.expirt) {
							// 时间没到，跳过
							continue;
						} else {
							// 时间到了，可以再次投递了
							it.remove();
							Messages.this.post(wrapper.message);
						}
					}
				} catch (Throwable t) {
					logger.warn("punish post message failed!", t);
				}

			}
		}

	};

	/**
	 * Post.
	 *
	 * @param msg the msg
	 */
	public void post(Message<?> msg) {
		if (null == msg) {
			return;
		}

		int reTry = msg.getReTry();
		if (max_retry <= reTry) {
			return;
		}

		msg.inc();

		if (reTry == 0) {
			normalPost(msg);
		}

		else {
			punishPost(msg);
		}

	}

	/**
	 * Normal post.
	 *
	 * @param msg the msg
	 */
	private void normalPost(Message<?> msg) {
		final Class<?> clazz = msg.getClass();
		final Set<MessageSubscriber> subscribers = subscriptionRelationships.get(clazz);
		if (subscribers == null || subscribers.isEmpty()) {
			return;
		}
		final Iterator<MessageSubscriber> subIt = subscribers.iterator();
		while (subIt.hasNext()) {
			MessageSubscriber subscriber = subIt.next();
			try {
				subscriber.receive(msg);
			} catch (Throwable t) {
				post(msg);
			}
		}

	}

	/**
	 * Punish post.
	 *
	 * @param msg the msg
	 */
	private void punishPost(Message<?> msg) {
		long now = System.currentTimeMillis();
		long punishTime = msg.getReTry() * punish_time_step;
		punishPostRing.insert(new Wrapper(msg, now + punishTime));
	}

	/**
	 * Register.
	 *
	 * @param subscriber the subscriber
	 * @param msgTypes the msg types
	 */
	public static synchronized void register(MessageSubscriber subscriber, Class<?>... msgTypes) {
		if (msgTypes == null || msgTypes.length == 0 || null == subscriber) {
			return;
		}
		for (Class<?> clazz : msgTypes) {
			final Set<MessageSubscriber> subscribers;
			if (!subscriptionRelationships.containsKey(clazz)) {
				subscribers = Sets.newHashSet();
				subscriptionRelationships.put(clazz, subscribers);
			} else {
				subscribers = subscriptionRelationships.get(clazz);
			}//if
			subscribers.add(subscriber);
		}
	}

	@Override
	protected void doStart() throws RebirthException {
		deamon.setDaemon(true);
		deamon.start();
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void doStop() throws RebirthException {
		deamon.stop();
	}

	@Override
	protected void doClose() throws RebirthException {

	}
}
