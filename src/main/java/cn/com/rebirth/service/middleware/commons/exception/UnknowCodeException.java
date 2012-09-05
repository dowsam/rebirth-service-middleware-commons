/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons UnknowCodeException.java 2012-7-17 12:19:58 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.exception;

import cn.com.rebirth.commons.exception.RebirthException;

/**
 * The Class UnknowCodeException.
 *
 * @author l.xue.nong
 */
public class UnknowCodeException extends RebirthException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -356285251040980622L;

	/**
	 * Instantiates a new unknow code exception.
	 *
	 * @param msg the msg
	 * @param cause the cause
	 */
	public UnknowCodeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	/**
	 * Instantiates a new unknow code exception.
	 *
	 * @param msg the msg
	 */
	public UnknowCodeException(String msg) {
		super(msg);
	}

}
