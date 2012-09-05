/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons ThreadPoolOverflowException.java 2012-7-17 12:19:36 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.exception;

import cn.com.rebirth.commons.exception.RebirthException;

/**
 * The Class ThreadPoolOverflowException.
 *
 * @author l.xue.nong
 */
public class ThreadPoolOverflowException extends RebirthException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7391314305576555449L;

	/**
	 * Instantiates a new thread pool overflow exception.
	 *
	 * @param msg the msg
	 * @param cause the cause
	 */
	public ThreadPoolOverflowException(String msg, Throwable cause) {
		super(msg, cause);
	}

	/**
	 * Instantiates a new thread pool overflow exception.
	 *
	 * @param msg the msg
	 */
	public ThreadPoolOverflowException(String msg) {
		super(msg);
	}

}
