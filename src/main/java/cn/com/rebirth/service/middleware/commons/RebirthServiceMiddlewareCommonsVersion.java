/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-commons RebirthServiceMiddlewareCommonsVersion.java 2012-7-17 11:47:42 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons;

import cn.com.rebirth.commons.AbstractVersion;
import cn.com.rebirth.commons.Version;

/**
 * The Class RebirthServiceMiddlewareCommonsVersion.
 *
 * @author l.xue.nong
 */
public class RebirthServiceMiddlewareCommonsVersion extends AbstractVersion implements Version {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3847371990689704073L;

	/* (non-Javadoc)
	 * @see cn.com.rebirth.commons.Version#getModuleName()
	 */
	@Override
	public String getModuleName() {
		return "rebirth-service-middleware-commons";
	}

}
