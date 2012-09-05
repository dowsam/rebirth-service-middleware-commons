/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons RmiRequest.java 2012-7-17 12:27:23 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.protocol;

import java.io.Serializable;

import cn.com.rebirth.commons.settings.Settings;

/**
 * The Class RmiRequest.
 *
 * @author l.xue.nong
 */
public final class RmiRequest extends RmiTracer implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 823825583753849024L;

	/** The key. */
	private final String key;

	/** The group. */
	private final String group;

	/** The version. */
	private final String version;

	/** The sign. */
	private final String sign;

	/** The args. */
	private final Serializable[] args;

	/** The app name. */
	private final String appName;

	/** The timeout. */
	private final long timeout;

	/**
	 * Instantiates a new rmi request.
	 *
	 * @param group the group
	 * @param version the version
	 * @param sign the sign
	 * @param args the args
	 * @param appName the app name
	 * @param timeout the timeout
	 */
	public RmiRequest(Settings settings, String group, String version, String sign, Serializable[] args,
			String appName, long timeout) {
		super(settings);
		this.group = group;
		this.version = version;
		this.sign = sign;
		this.args = args;
		this.appName = appName;
		this.timeout = timeout;
		this.key = group + version + sign;
	}

	/**
	 * Instantiates a new rmi request.
	 *
	 * @param req the req
	 */
	public RmiRequest(RmiRequest req) {
		super(req.getToken());
		this.group = req.group;
		this.version = req.version;
		this.sign = req.sign;
		this.args = req.args;
		this.appName = req.appName;
		this.timeout = req.timeout;
		this.key = group + version + sign;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Gets the app name.
	 *
	 * @return the app name
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * Gets the group.
	 *
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Gets the sign.
	 *
	 * @return the sign
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * Gets the args.
	 *
	 * @return the args
	 */
	public Serializable[] getArgs() {
		return args;
	}

	/**
	 * Gets the timeout.
	 *
	 * @return the timeout
	 */
	public long getTimeout() {
		return timeout;
	}

}
