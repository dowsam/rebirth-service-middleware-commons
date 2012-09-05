/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons Protocol.java 2012-7-17 12:24:23 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.protocol;

/**
 * The Class Protocol.
 *
 * @author l.xue.nong
 */
public final class Protocol {

	/** The Constant MAGIC. */
	public static final short MAGIC = 0x0c9f;

	/** The type rmi. */
	public static byte TYPE_RMI = 0x01;

	/** The type heartbeat. */
	public static byte TYPE_HEARTBEAT = 0x02;

	/** The type. */
	private byte type;

	/** The length. */
	private int length;

	/** The datas. */
	private byte[] datas;

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public byte getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(byte type) {
		this.type = type;
	}

	/**
	 * Gets the length.
	 *
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Sets the length.
	 *
	 * @param length the new length
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * Gets the datas.
	 *
	 * @return the datas
	 */
	public byte[] getDatas() {
		return datas;
	}

	/**
	 * Sets the datas.
	 *
	 * @param datas the new datas
	 */
	public void setDatas(byte[] datas) {
		this.datas = datas;
	}

}
