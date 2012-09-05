/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons HessianSerializer.java 2012-7-17 11:52:34 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.serializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

/**
 * The Class HessianSerializer.
 *
 * @author l.xue.nong
 */
public class HessianSerializer implements Serializer {

	/* (non-Javadoc)
	 * @see cn.com.rebirth.service.middleware.commons.serializer.Serializer#encode(java.io.Serializable)
	 */
	@Override
	public <T extends Serializable> byte[] encode(T serializable) throws SerializationException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		HessianOutput ho = new HessianOutput(os);
		try {
			ho.writeObject(serializable);
		} catch (IOException e) {
			throw new SerializationException(e.getMessage(), e);
		}
		return os.toByteArray();
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.service.middleware.commons.serializer.Serializer#decode(byte[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Serializable> T decode(byte[] bytes) throws SerializationException {
		ByteArrayInputStream is = new ByteArrayInputStream(bytes);
		HessianInput hi = new HessianInput(is);
		try {
			return (T) hi.readObject();
		} catch (IOException e) {
			throw new SerializationException(e.getMessage(), e);
		}
	}

}
