/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-server MessageSubscriber.java 2012-7-17 10:39:35 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons;

import cn.com.rebirth.commons.exception.RebirthException;

/**
 * The Interface MessageSubscriber.
 *
 * @author l.xue.nong
 */
public interface MessageSubscriber {

	/**
	 * Receive.
	 *
	 * @param msg the msg
	 * @throws RebirthException the rebirth exception
	 */
	void receive(Message<?> msg) throws RebirthException;
}
