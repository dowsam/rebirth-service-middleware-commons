/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons JsonSerializerException.java 2012-8-28 12:46:24 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.serializer;

import cn.com.rebirth.commons.exception.RebirthException;

/**
 * The Class JsonSerializerException.
 *
 * @author l.xue.nong
 */
public class JsonSerializerException extends RebirthException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2281546980037451466L;

	/**
	 * Instantiates a new json serializer exception.
	 *
	 * @param msg the msg
	 * @param cause the cause
	 */
	public JsonSerializerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	/**
	 * Instantiates a new json serializer exception.
	 *
	 * @param msg the msg
	 */
	public JsonSerializerException(String msg) {
		super(msg);
	}

}
