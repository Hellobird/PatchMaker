package gnnt.MEBS.patchmaker.creator;

import gnnt.MEBS.patchmaker.PatchException;
import gnnt.MEBS.patchmaker.source.ISource;

/*******************************************************************
 * ICreator.java 2017年9月7日
 * <p>
 * class desc:补丁生成接口
 * </p>
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * 
 * @author:ZhouPeng
 * 
 ******************************************************************/
public interface ICreator {

	/**
	 * 获取补丁内容
	 * 
	 * @param oldContent
	 *            旧内容
	 * @param newSource
	 *            新内容
	 * @return 补丁内容
	 * @throws CreatorException
	 */
	String getPatch(ISource oldSource, ISource newSource) throws PatchException;
}
