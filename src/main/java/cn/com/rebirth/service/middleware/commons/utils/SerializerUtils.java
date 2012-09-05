/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons SerializerUtils.java 2012-7-17 12:01:37 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.utils;

import java.io.Serializable;

/**
 * The Class SerializerUtils.
 *
 * @author l.xue.nong
 */
public abstract class SerializerUtils {

	/**
	 * Checks if is serializable type.
	 *
	 * @param type the type
	 * @return true, if is serializable type
	 */
	public static boolean isSerializableType(Class<?> type) {

		if (Void.class.isAssignableFrom(type)) {
			return true;
		}

		if (Object.class.isAssignableFrom(type) && !Serializable.class.isAssignableFrom(type)) {
			return false;
		}

		return true;
	}

	/**
	 * Checks if is serializable type.
	 *
	 * @param types the types
	 * @return true, if is serializable type
	 */
	public static boolean isSerializableType(Class<?>... types) {

		if (null == types || types.length == 0) {
			return true;
		}

		for (Class<?> type : types) {
			if (!isSerializableType(type)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Change to serializable.
	 *
	 * @param args the args
	 * @return the serializable[]
	 */
	public static Serializable[] changeToSerializable(Object[] args) {
		if (null == args) {
			return null;
		}
		Serializable[] serializables = new Serializable[args.length];
		for (int index = 0; index < args.length; index++) {
			serializables[index] = (Serializable) args[index];
		}
		return serializables;
	}
}
