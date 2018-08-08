package gnnt.MEBS.patchmaker;

import gnnt.MEBS.patchmaker.creator.GoogleDiffCreator;
import gnnt.MEBS.patchmaker.merge.GoogleDiffMerger;

/*******************************************************************
 * GoogleDiffPatchMakerFactory.java 2017年9月8日
 * <p>
 * class desc:使用google差异解析的PatchMaker工厂
 * </p>
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * 
 * @author:ZhouPeng
 * 
 ******************************************************************/
public class GoogleDiffPatchMakerFactory {

	/**
	 * 获取google差异解析补丁生成与合并类
	 * 
	 * @return
	 */
	public static final PatchMaker getPatchMaker() {
		PatchMaker patchMaker = new PatchMaker();
		patchMaker.setCreator(new GoogleDiffCreator());
		patchMaker.setMerger(new GoogleDiffMerger());
		return patchMaker;
	}
}
