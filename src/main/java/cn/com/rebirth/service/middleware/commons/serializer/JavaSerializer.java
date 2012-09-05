package cn.com.rebirth.service.middleware.commons.serializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class JavaSerializer implements Serializer {

	@Override
	public <T extends Serializable> byte[] encode(T serializable) throws SerializationException {
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(serializable);
		} catch (IOException e) {
			throw new SerializationException(e.getMessage(), e);
		} finally {
			try {
				if (null != oos) {
					oos.close();
				}
			} catch (Exception e) {
				//donothing
			}
		}
		return baos.toByteArray();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Serializable> T decode(byte[] bytes) throws SerializationException {
		final ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(bais);
			return (T) ois.readObject();
		} catch (IOException e) {
			throw new SerializationException(e.getMessage(), e);
		} catch (ClassNotFoundException cnfe) {
			throw new SerializationException(cnfe.getMessage(), cnfe);
		} finally {
			try {
				if (null != ois) {
					ois.close();
				}
			} catch (Exception e) {
				//donothing
			}
		}
	}

}
