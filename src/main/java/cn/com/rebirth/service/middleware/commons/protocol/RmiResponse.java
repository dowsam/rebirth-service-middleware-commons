/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons RmiResponse.java 2012-7-17 12:27:50 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.protocol;

import java.io.Serializable;

/**
 * The Class RmiResponse.
 *
 * @author l.xue.nong
 */
public final class RmiResponse extends RmiTracer {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2335302314388825625L;

	/** The Constant RESULT_CODE_SUCCESSED_RETURN. */
	public static final short RESULT_CODE_SUCCESSED_RETURN = 1;

	/** The Constant RESULT_CODE_SUCCESSED_THROWABLE. */
	public static final short RESULT_CODE_SUCCESSED_THROWABLE = 2;

	/** The Constant RESULT_CODE_FAILED_BIZ_THREAD_POOL_OVERFLOW. */
	public static final short RESULT_CODE_FAILED_BIZ_THREAD_POOL_OVERFLOW = 4;

	/** The Constant RESULT_CODE_FAILED_SERVICE_NOT_FOUND. */
	public static final short RESULT_CODE_FAILED_SERVICE_NOT_FOUND = 5;

	/** The Constant RESULT_CODE_FAILED_TIMEOUT. */
	public static final short RESULT_CODE_FAILED_TIMEOUT = 6;

	/** The code. */
	private final short code;

	/** The object. */
	private final Serializable object;

	/**
	 * Instantiates a new rmi response.
	 *
	 * @param req the req
	 * @param code the code
	 * @param object the object
	 */
	public RmiResponse(RmiRequest req, short code, Serializable object) {
		super(req.getId(), req.getToken());
		this.code = code;
		this.object = object;
	}

	/**
	 * Instantiates a new rmi response.
	 *
	 * @param req the req
	 * @param code the code
	 */
	public RmiResponse(RmiRequest req, short code) {
		super(req.getId(), req.getToken());
		this.code = code;
		this.object = null;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public short getCode() {
		return code;
	}

	/**
	 * Gets the object.
	 *
	 * @return the object
	 */
	public Serializable getObject() {
		return object;
	}

}
