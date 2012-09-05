/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons ProtocolEncoder.java 2012-7-17 12:25:05 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.protocol.coder;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

import cn.com.rebirth.service.middleware.commons.protocol.Protocol;

/**
 * The Class ProtocolEncoder.
 *
 * @author l.xue.nong
 */
public class ProtocolEncoder extends OneToOneEncoder {

	/* (non-Javadoc)
	 * @see org.jboss.netty.handler.codec.oneone.OneToOneEncoder#encode(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.Channel, java.lang.Object)
	 */
	@Override
	protected Object encode(ChannelHandlerContext ctx, Channel channel, Object msg) throws Exception {

		if (null == msg || !(msg instanceof Protocol)) {
			return msg;
		}

		Protocol protocol = (Protocol) msg;

		ChannelBuffer buffer = ChannelBuffers.dynamicBuffer();
		buffer.writeShort(Protocol.MAGIC);
		buffer.writeByte(protocol.getType());
		buffer.writeInt(protocol.getLength());
		buffer.writeBytes(protocol.getDatas());

		return buffer;
	}

}
