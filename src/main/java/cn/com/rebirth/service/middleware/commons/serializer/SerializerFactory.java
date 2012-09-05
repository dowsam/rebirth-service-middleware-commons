/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons SerializerFactory.java 2012-7-17 12:00:09 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.serializer;

import cn.com.rebirth.commons.component.AbstractComponent;
import cn.com.rebirth.commons.exception.RebirthException;
import cn.com.rebirth.commons.settings.Settings;

/**
 * A factory for creating Serializer objects.
 */
public class SerializerFactory extends AbstractComponent {

	/** The serializer type. */
	private final Class<?> serializerType;

	/**
	 * Instantiates a new serializer factory.
	 *
	 * @param settings the settings
	 */
	public SerializerFactory(Settings settings) {
		super(settings);
		this.serializerType = this.componentSettings.getAsClass("serializer_type", JavaSerializer.class);
	}

	/**
	 * Gets the serializer.
	 *
	 * @return the serializer
	 */
	public Serializer getSerializer() {
		try {
			return (Serializer) this.serializerType.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			throw new RebirthException(e.getMessage(), e);
		}
	}
}
