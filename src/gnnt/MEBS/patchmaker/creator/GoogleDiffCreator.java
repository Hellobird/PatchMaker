package gnnt.MEBS.patchmaker.creator;

import gnnt.MEBS.patchmaker.PatchException;
import gnnt.MEBS.patchmaker.diff_match_patch;
import gnnt.MEBS.patchmaker.source.ISource;

/*******************************************************************
 * GoogleDiffCreator.java 2017年9月7日
 * <p>
 * class desc:使用谷歌diff_match_patch的生成器
 * </p>
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * 
 * @author:ZhouPeng
 * 
 ******************************************************************/
public class GoogleDiffCreator implements ICreator {

	@Override
	public String getPatch(ISource oldSource, ISource newSource) throws PatchException {
		if (newSource == null) {
			throw new PatchException("新版本数据源为空，请确认配置是否正确");
		}
		String oldString = "";
		String newString;
		// 如果旧内容不为空，则获取
		if (oldSource != null) {
			oldString = oldSource.getSourceString();
		}
		newString = newSource.getSourceString();
		// 生成补丁内容
		diff_match_patch pathUtil = new diff_match_patch();
		String patch;
		try {
			patch = pathUtil.patch_toText(pathUtil.patch_make(oldString, newString));
		} catch (Exception e) {
			throw new PatchException("生成补丁异常：" + e.getMessage());
		}
		return patch;
	}

}
