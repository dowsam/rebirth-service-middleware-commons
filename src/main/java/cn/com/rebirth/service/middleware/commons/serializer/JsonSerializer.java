/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons JsonSerializer.java 2012-8-28 12:34:46 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.serializer;

/**
 * The Interface JsonSerializer.
 *
 * @author l.xue.nong
 */
public interface JsonSerializer {

	/**
	 * Encode.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @return the string
	 */
	<T> String encode(T object) throws JsonSerializerException;

	/**
	 * Decode.
	 *
	 * @param <T> the generic type
	 * @param json the json
	 * @return the t
	 */
	<T> T decode(String json, Class<T> entityClass) throws JsonSerializerException;

}
