/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons SerializationException.java 2012-7-17 11:48:31 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.serializer;

import cn.com.rebirth.commons.exception.RebirthException;

/**
 * The Class SerializationException.
 *
 * @author l.xue.nong
 */
public class SerializationException extends RebirthException {

	/**
	 * Instantiates a new serialization exception.
	 *
	 * @param msg the msg
	 */
	public SerializationException(String msg) {
		super(msg);
	}

	/**
	 * Instantiates a new serialization exception.
	 *
	 * @param msg the msg
	 * @param cause the cause
	 */
	public SerializationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7598601284875529520L;

}
