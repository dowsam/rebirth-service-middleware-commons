/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons SignatureUtils.java 2012-7-17 12:03:24 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.utils;

import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import cn.com.rebirth.commons.exception.RebirthException;

import com.google.common.collect.Maps;

/**
 * The Class SignatureUtils.
 *
 * @author l.xue.nong
 */
public abstract class SignatureUtils {

	/** The method sign cache. */
	private static Map<Keys, String> methodSignCache = Maps.newConcurrentMap();

	private static class Keys {
		public Class<?> targetInterface;
		public Method method;

		public Keys(Class<?> targetInterface, Method method) {
			super();
			this.targetInterface = targetInterface;
			this.method = method;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((method == null) ? 0 : method.hashCode());
			result = prime * result + ((targetInterface == null) ? 0 : targetInterface.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Keys other = (Keys) obj;
			if (method == null) {
				if (other.method != null)
					return false;
			} else if (!method.equals(other.method))
				return false;
			if (targetInterface == null) {
				if (other.targetInterface != null)
					return false;
			} else if (!targetInterface.equals(other.targetInterface))
				return false;
			return true;
		}

	}

	/**
	 * Signature.
	 *
	 * @param method the method
	 * @return the string
	 */
	public static String signature(Class<?> targetInterface, Method method) {
		Keys keys = new Keys(targetInterface, method);
		if (methodSignCache.containsKey(keys)) {
			return methodSignCache.get(keys);
		}

		final StringBuilder paramTypeStrSB = new StringBuilder();
		final Class<?>[] paramTypes = method.getParameterTypes();
		if (null != paramTypes && paramTypes.length != 0) {
			for (int index = 0; index < paramTypes.length; index++) {
				paramTypeStrSB.append(paramTypes[index].getName());
				if (index != paramTypes.length - 1) {
					paramTypeStrSB.append(",");
				}
			}//for
		}//if

		final String signStr = String.format("%s %s.%s(%s)", method.getReturnType().getName(), method
				.getDeclaringClass().getName(), method.getName(), paramTypeStrSB.toString());

		String signMD5 = md5(targetInterface.getName() + signStr);
		methodSignCache.put(keys, signMD5);
		return signMD5;
	}

	/**
	 * Md5.
	 *
	 * @param str the str
	 * @return the string
	 */
	public static String md5(String str) {
		final MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RebirthException(e.getMessage(), e);
		}

		byte[] byteArray = messageDigest.digest();

		StringBuilder md5SB = new StringBuilder();
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
				md5SB.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			} else {
				md5SB.append(Integer.toHexString(0xFF & byteArray[i]));
			}
		}//for

		return md5SB.toString();
	}
}
