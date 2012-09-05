/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons ProviderNotFoundException.java 2012-7-17 12:18:57 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.exception;

import cn.com.rebirth.commons.exception.RebirthException;

/**
 * The Class ProviderNotFoundException.
 *
 * @author l.xue.nong
 */
public class ProviderNotFoundException extends RebirthException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3148619368309599511L;

	/**
	 * Instantiates a new provider not found exception.
	 *
	 * @param msg the msg
	 * @param cause the cause
	 */
	public ProviderNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

	/**
	 * Instantiates a new provider not found exception.
	 *
	 * @param msg the msg
	 */
	public ProviderNotFoundException(String msg) {
		super(msg);
	}

}
