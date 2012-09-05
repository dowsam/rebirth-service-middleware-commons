/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-server Message.java 2012-7-17 10:38:50 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons;

/**
 * The Class Message.
 *
 * @param <T> the generic type
 * @author l.xue.nong
 */
public class Message<T> {

	/** The content. */
	private final T content; //消息内容

	/** The re try. */
	private int reTry; //本消息重试投递次数

	/**
	 * Instantiates a new message.
	 *
	 * @param t the t
	 */
	public Message(T t) {
		this.content = t;
		this.reTry = 0;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public T getContent() {
		return content;
	}

	/**
	 * Gets the re try.
	 *
	 * @return the re try
	 */
	public int getReTry() {
		return reTry;
	}

	/**
	 * Inc.
	 *
	 * @return the message
	 */
	public Message<T> inc() {
		reTry++;
		return this;
	}
}
