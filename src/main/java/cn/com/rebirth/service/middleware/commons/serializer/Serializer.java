/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons Serializer.java 2012-7-17 11:49:07 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.serializer;

import java.io.Serializable;

/**
 * The Interface Serializer.
 *
 * @author l.xue.nong
 */
public interface Serializer {

	/**
	 * Encode.
	 *
	 * @param <T> the generic type
	 * @param serializable the serializable
	 * @return the byte[]
	 * @throws SerializationException the serialization exception
	 */
	<T extends Serializable> byte[] encode(T serializable) throws SerializationException;

	/**
	 * Decode.
	 *
	 * @param <T> the generic type
	 * @param bytes the bytes
	 * @return the t
	 * @throws SerializationException the serialization exception
	 */
	<T extends Serializable> T decode(byte[] bytes) throws SerializationException;
}
