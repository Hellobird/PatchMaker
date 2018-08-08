package gnnt.MEBS.patchmaker.output;

import gnnt.MEBS.patchmaker.PatchException;

/*******************************************************************
 * IOutput.java 2017年9月7日
 * <p>
 * class desc:输出类
 * </p>
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * 
 * @author:ZhouPeng
 * 
 ******************************************************************/
public interface IOutput {

	/**
	 * 输出内容
	 * 
	 * @param patchedContent
	 *            打补丁后的内容
	 * @throws OutputException
	 * @return 是否正确输出
	 */
	boolean outputPatchedContent(String content) throws PatchException;
}
