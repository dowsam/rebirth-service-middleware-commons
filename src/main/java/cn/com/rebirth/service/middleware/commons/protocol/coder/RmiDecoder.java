/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons RmiDecoder.java 2012-7-17 12:26:06 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.protocol.coder;

import static cn.com.rebirth.service.middleware.commons.protocol.Protocol.TYPE_RMI;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;

import cn.com.rebirth.service.middleware.commons.protocol.Protocol;
import cn.com.rebirth.service.middleware.commons.protocol.RmiTracer;
import cn.com.rebirth.service.middleware.commons.serializer.Serializer;
import cn.com.rebirth.service.middleware.commons.serializer.SerializerFactory;

/**
 * The Class RmiDecoder.
 *
 * @author l.xue.nong
 */
public class RmiDecoder extends OneToOneDecoder {

	/** The serializer. */
	private final Serializer serializer;

	public RmiDecoder(SerializerFactory serializerFactory) {
		super();
		this.serializer = serializerFactory.getSerializer();
	}

	/* (non-Javadoc)
	 * @see org.jboss.netty.handler.codec.oneone.OneToOneDecoder#decode(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.Channel, java.lang.Object)
	 */
	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel channel, Object msg) throws Exception {
		Protocol pro = (Protocol) msg;
		if (pro.getType() != TYPE_RMI) {
			return null;
		}
		RmiTracer rmiTracer = serializer.decode(pro.getDatas());
		return rmiTracer;
	}

}
