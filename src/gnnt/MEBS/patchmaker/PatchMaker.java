package gnnt.MEBS.patchmaker;

import gnnt.MEBS.patchmaker.creator.ICreator;
import gnnt.MEBS.patchmaker.merge.IMerger;
import gnnt.MEBS.patchmaker.output.IOutput;
import gnnt.MEBS.patchmaker.source.ISource;
import gnnt.MEBS.patchmaker.source.SimpleStringSource;

/*******************************************************************
 * GoogleDiffPatch.java 2017年9月8日
 * <p>
 * class desc:
 * </p>
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * 
 * @author:ZhouPeng
 * 
 ******************************************************************/
public class PatchMaker {

	/**
	 * 补丁生成
	 */
	public ICreator creator;

	/**
	 * 补丁合并
	 */
	public IMerger merger;

	public PatchMaker() {
	}

	public ICreator getCreator() {
		return creator;
	}

	public void setCreator(ICreator creator) {
		this.creator = creator;
	}

	public IMerger getMerger() {
		return merger;
	}

	public void setMerger(IMerger merger) {
		this.merger = merger;
	}

	/**
	 * 根据新旧版本内容获取补丁字符串
	 * 
	 * @param oldContent
	 *            旧版本内容
	 * @param newContent
	 *            新版本内容
	 * @return 返回补丁字符串
	 * @throws PatchException
	 */
	public String getPatchString(String oldContent, String newContent) throws PatchException {
		return getPatchString(new SimpleStringSource(oldContent), new SimpleStringSource(oldContent));
	}

	/**
	 * 根据新旧版本内容获取补丁字符串
	 * 
	 * @param oldSource
	 *            旧版本
	 * @param newSource
	 *            新版本
	 * @return 返回补丁字符串
	 */
	public String getPatchString(ISource oldSource, ISource newSource) throws PatchException {
		if (creator == null) {
			throw new PatchException("Patch error: creator cannot be null, please setCreator first.");
		}
		return creator.getPatch(oldSource, newSource);
	}

	/**
	 * 根据新旧版本内容获输出补丁字符串
	 * 
	 * @param oldSource
	 *            旧版本
	 * @param newSource
	 *            新版本
	 * @param output
	 *            输出者
	 * @return 是否创建成功
	 */
	public boolean createPatch(ISource oldSource, ISource newSource, IOutput output) {
		if (output == null) {
			System.out.println("Patch error: output cannot be null, please setOutput first.");
			return false;
		}
		try {
			return output.outputPatchedContent(getPatchString(oldSource, newSource));
		} catch (Exception e) {
			if (e != null) {
				System.out.println("Patch error:" + e.getMessage());
			}
		}
		return false;
	}

	/**
	 * 根据新旧版本内容获输出补丁字符串
	 * 
	 * @param oldContent
	 *            旧版本内容
	 * @param newContent
	 *            新版本内容
	 * @param output
	 *            输出者
	 * @return 是否成功
	 */
	public boolean createPatch(String oldContent, String newContent, IOutput output) {
		return createPatch(new SimpleStringSource(oldContent), new SimpleStringSource(newContent), output);
	}

	/**
	 * 获取应用补丁后的版本字符串
	 * 
	 * @param oldSource
	 *            旧版本
	 * @param patchSource
	 *            补丁源
	 * @return 返回应用补丁后的版本
	 * @throws PatchException
	 *             补丁相关异常
	 */
	public String getApplyPatchString(String oldContent, String patchContent) throws PatchException {
		return getApplyPatchString(new SimpleStringSource(oldContent), new SimpleStringSource(patchContent));
	}

	/**
	 * 获取应用补丁后的版本字符串
	 * 
	 * @param oldSource
	 *            旧版本
	 * @param patchSource
	 *            补丁源
	 * @return 返回应用补丁后的版本
	 * @throws PatchException
	 *             补丁相关异常
	 */
	public String getApplyPatchString(ISource oldSource, ISource patchSource) throws PatchException {
		if (merger == null) {
			throw new PatchException("Patch error: merger cannot be null, please setMerger first.");
		}
		return merger.mergePatch(oldSource, patchSource);
	}

	/**
	 * 应用补丁到旧版本，并输出新版本内容
	 * 
	 * @param oldContent
	 *            旧版本
	 * @param patchContent
	 *            补丁
	 * @param output
	 *            输出者
	 * @return 是否成功
	 */
	public boolean applyPatch(String oldContent, String patchContent, IOutput output) {
		return applyPatch(new SimpleStringSource(oldContent), new SimpleStringSource(patchContent), output);
	}

	/**
	 * 应用补丁到旧版本，并输出新版本内容
	 * 
	 * @param oldContent
	 *            旧版本
	 * @param patchContent
	 *            补丁
	 * @param output
	 *            输出者
	 * @return 是否成功
	 */
	public boolean applyPatch(ISource oldSource, ISource patchSource, IOutput output) {
		if (output == null) {
			System.out.println("Patch error: output cannot be null, please setOutput first.");
			return false;
		}

		try {
			return output.outputPatchedContent(merger.mergePatch(oldSource, patchSource));
		} catch (Exception e) {
			if (e != null) {
				System.out.println("Patch error:" + e.getMessage());
			}
		}
		return false;
	}

}
