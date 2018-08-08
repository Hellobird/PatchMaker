package gnnt.MEBS.patchmaker.merge;

import java.util.LinkedList;

import gnnt.MEBS.patchmaker.PatchException;
import gnnt.MEBS.patchmaker.diff_match_patch;
import gnnt.MEBS.patchmaker.diff_match_patch.Patch;
import gnnt.MEBS.patchmaker.source.ISource;

/*******************************************************************
 * GoogleDiffMerge.java 2017年9月7日
 * <p>
 * class desc:使用谷歌diff_match_patch的合并器
 * </p>
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * 
 * @author:ZhouPeng
 * 
 ******************************************************************/
public class GoogleDiffMerger implements IMerger {

	@Override
	public String mergePatch(ISource oldSource, ISource patchSource) throws PatchException {
		if (patchSource == null) {
			throw new PatchException("补丁源不能为空");
		}
		String oldString = "";
		if (oldSource != null) {
			oldString = oldSource.getSourceString();
		}
		String patchString = patchSource.getSourceString();

		// 合并补丁生成新文件
		String patchedString;

		try {
			diff_match_patch patchUtil = new diff_match_patch();
			Object[] response = patchUtil.patch_apply((LinkedList<Patch>) patchUtil.patch_fromText(patchString),
					oldString);
			// 判断解析结果
			boolean[] resultArray = (boolean[]) response[1];
			boolean result = true;
			for (boolean lineResult : resultArray) {
				// 如果有一次失败，则认定为失败
				if (!lineResult) {
					result = false;
					break;
				}
			}
			// 判断是否更新成功
			if (result) {
				patchedString = response[0].toString();
			} else {
				throw new PatchException("更新补丁失败，未知原因");
			}
		} catch (Exception e) {
			throw new PatchException("更新补丁失败：" + e.getMessage());
		}
		return patchedString;
	}

}
