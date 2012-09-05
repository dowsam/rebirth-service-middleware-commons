/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons RmiTracer.java 2012-7-17 12:29:10 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.protocol;

import static java.lang.System.currentTimeMillis;

import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.lang3.StringUtils;

import cn.com.rebirth.commons.settings.Settings;

/**
 * The Class RmiTracer.
 *
 * @author l.xue.nong
 */
public class RmiTracer implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -940954284480781971L;

	/** The Constant seq. */
	private static transient final AtomicLong seq = new AtomicLong();

	/** The id. */
	private final long id;

	/** The token. */
	private final String token;

	/** The timestamp. */
	private long timestamp;

	/**
	 * Instantiates a new rmi tracer.
	 *
	 * @param id the id
	 * @param token the token
	 */
	public RmiTracer(long id, String token) {
		this.id = id;
		this.token = token;
		this.timestamp = currentTimeMillis();
	}

	/**
	 * Instantiates a new rmi tracer.
	 *
	 * @param token the token
	 */
	public RmiTracer(String token) {
		this.id = seq.incrementAndGet();
		this.token = token;
		this.timestamp = currentTimeMillis();
	}

	/**
	 * Instantiates a new rmi tracer.
	 */
	public RmiTracer(Settings settings) {
		this.id = seq.incrementAndGet();
		this.token = settings.getAsBoolean("isEnableTraceToken", true) ? StringUtils.EMPTY : UUID.randomUUID()
				.toString();
		this.timestamp = currentTimeMillis();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the new timestamp
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
