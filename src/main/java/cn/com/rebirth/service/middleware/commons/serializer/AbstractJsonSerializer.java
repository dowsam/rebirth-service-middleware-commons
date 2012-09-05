/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons AbstractJsonSerializer.java 2012-8-28 12:36:06 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.serializer;


/**
 * The Class AbstractJsonSerializer.
 *
 * @author l.xue.nong
 */
public abstract class AbstractJsonSerializer implements JsonSerializer {

	/**
	 * To json.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @return the string
	 */
	protected abstract <T> String toJson(T object);

	/**
	 * From json.
	 *
	 * @param <T> the generic type
	 * @param json the json
	 * @return the t
	 */
	protected abstract <T> T fromJson(String json, Class<T> entityClass);

	/* (non-Javadoc)
	 * @see cn.com.rebirth.service.middleware.commons.serializer.JsonSerializer#encode(java.lang.Object)
	 */
	@Override
	public <T> String encode(T object) {
		return toJson(object);
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.service.middleware.commons.serializer.JsonSerializer#decode(java.lang.String)
	 */
	@Override
	public <T> T decode(String json, Class<T> entityClass) {
		return fromJson(json, entityClass);
	}

}
