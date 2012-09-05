/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons RmiEncoder.java 2012-7-17 12:34:10 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.protocol.coder;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

import cn.com.rebirth.service.middleware.commons.protocol.Protocol;
import cn.com.rebirth.service.middleware.commons.protocol.RmiTracer;
import cn.com.rebirth.service.middleware.commons.serializer.Serializer;
import cn.com.rebirth.service.middleware.commons.serializer.SerializerFactory;

/**
 * The Class RmiEncoder.
 *
 * @author l.xue.nong
 */
public class RmiEncoder extends OneToOneEncoder {

	/** The serializer. */
	private final Serializer serializer;

	/**
	 * Instantiates a new rmi encoder.
	 *
	 * @param serializerFactory the serializer factory
	 */
	public RmiEncoder(SerializerFactory serializerFactory) {
		super();
		this.serializer = serializerFactory.getSerializer();
	}

	/* (non-Javadoc)
	 * @see org.jboss.netty.handler.codec.oneone.OneToOneEncoder#encode(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.Channel, java.lang.Object)
	 */
	@Override
	protected Object encode(ChannelHandlerContext ctx, Channel channel, Object msg) throws Exception {

		RmiTracer rmi = (RmiTracer) msg;
		Protocol pro = new Protocol();
		pro.setType(Protocol.TYPE_RMI);
		byte[] datas = serializer.encode(rmi);
		pro.setLength(datas.length);
		pro.setDatas(datas);

		return pro;
	}

}
