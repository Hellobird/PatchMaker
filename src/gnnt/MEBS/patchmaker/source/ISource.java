package gnnt.MEBS.patchmaker.source;

import gnnt.MEBS.patchmaker.PatchException;

/*******************************************************************
 * ISource.java 2017年9月7日
 * <p>
 * class desc: 数据源
 * </p>
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * 
 * @author:ZhouPeng
 * 
 ******************************************************************/
public interface ISource {

	/**
	 * 获取内容
	 * 
	 * @return 返回内容字符串
	 */
	String getSourceString() throws PatchException;
}
