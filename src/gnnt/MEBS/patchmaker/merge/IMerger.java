package gnnt.MEBS.patchmaker.merge;

import gnnt.MEBS.patchmaker.PatchException;
import gnnt.MEBS.patchmaker.source.ISource;

/*******************************************************************
 * IMerge.java 2017年9月7日
 * <p>
 * class desc:合并补丁
 * </p>
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * 
 * @author:ZhouPeng
 * 
 ******************************************************************/
public interface IMerger {

	/**
	 * 合并补丁
	 * 
	 * @param oldSource
	 *            旧内容
	 * @param patchSource
	 *            补丁内容
	 * @return 合并后内容
	 */
	String mergePatch(ISource oldSource, ISource patchSource) throws PatchException;
}
