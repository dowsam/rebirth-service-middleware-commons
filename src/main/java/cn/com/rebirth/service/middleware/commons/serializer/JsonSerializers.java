/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons JsonSerializers.java 2012-8-28 12:41:44 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.serializer;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class JsonSerializers.
 *
 * @author l.xue.nong
 */
public class JsonSerializers extends AbstractJsonSerializer implements JsonSerializer {

	/** The object mapper. */
	private ObjectMapper objectMapper;

	/**
	 * Instantiates a new json serializers.
	 *
	 * @param include the include
	 */
	public JsonSerializers(Include include) {
		objectMapper = new ObjectMapper();
		//设置输出时包含属性的风格
		if (include != null) {
			objectMapper.setSerializationInclusion(include);
		}
		//设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.service.middleware.commons.serializer.AbstractJsonSerializer#toJson(java.lang.Object)
	 */
	@Override
	protected <T> String toJson(T object) throws JsonSerializerException {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (Exception e) {
			throw new JsonSerializerException(e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.service.middleware.commons.serializer.AbstractJsonSerializer#fromJson(java.lang.String)
	 */
	@Override
	protected <T> T fromJson(String json, Class<T> entityClass) throws JsonSerializerException {
		try {
			return objectMapper.readValue(json, entityClass);
		} catch (Exception e) {
			throw new JsonSerializerException(e.getMessage(), e);
		}
	}

}
