/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons ServiceNotFoundException.java 2012-7-17 12:19:18 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.exception;

import cn.com.rebirth.commons.exception.RebirthException;

/**
 * The Class ServiceNotFoundException.
 *
 * @author l.xue.nong
 */
public class ServiceNotFoundException extends RebirthException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1556475261062935115L;

	/**
	 * Instantiates a new service not found exception.
	 *
	 * @param msg the msg
	 * @param cause the cause
	 */
	public ServiceNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

	/**
	 * Instantiates a new service not found exception.
	 *
	 * @param msg the msg
	 */
	public ServiceNotFoundException(String msg) {
		super(msg);
	}

}
