/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons ProtocolDecoder.java 2012-7-17 12:24:35 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons.protocol.coder;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.handler.codec.frame.FrameDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.rebirth.service.middleware.commons.protocol.Protocol;

/**
 * The Class ProtocolDecoder.
 *
 * @author l.xue.nong
 */
public class ProtocolDecoder extends FrameDecoder {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(ProtocolDecoder.class);

	/* (non-Javadoc)
	 * @see org.jboss.netty.handler.codec.frame.FrameDecoder#decode(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.Channel, org.jboss.netty.buffer.ChannelBuffer)
	 */
	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer) throws Exception {

		Protocol pro = (Protocol) ctx.getAttachment();
		if (null == pro) {
			pro = new Protocol();
			if (buffer.readableBytes() < 56/* magic(16)+type(8)+len(32) */) {
				return null;
			} else {
				fillHeader(pro, buffer);
			}
		}// if

		if (buffer.readableBytes() < pro.getLength()) {
			ctx.setAttachment(pro);
			return null;
		}

		fillData(pro, buffer);
		ctx.setAttachment(null);

		return pro;
	}

	/**
	 * Fill header.
	 *
	 * @param pro the pro
	 * @param buffer the buffer
	 */
	private void fillHeader(Protocol pro, ChannelBuffer buffer) {
		final short magic = buffer.readShort();
		final byte type = buffer.readByte();
		final int len = buffer.readInt();

		if (Protocol.MAGIC != magic) {
			throw new IllegalStateException(
					String.format("magic=%d does not match, connection will disconnect!", magic));
		}

		pro.setType(type);
		pro.setLength(len);

	}

	/**
	 * Fill data.
	 *
	 * @param pro the pro
	 * @param buffer the buffer
	 */
	private void fillData(Protocol pro, ChannelBuffer buffer) {
		byte[] datas = new byte[pro.getLength()];
		buffer.readBytes(datas);
		pro.setDatas(datas);
	}

	/* (non-Javadoc)
	 * @see org.jboss.netty.handler.codec.frame.FrameDecoder#exceptionCaught(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ExceptionEvent)
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
		logger.error("decode protocol failed!", e.getCause());
		ctx.getChannel().close();
		super.exceptionCaught(ctx, e);
	}

}
