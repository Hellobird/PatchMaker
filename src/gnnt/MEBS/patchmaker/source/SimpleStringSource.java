package gnnt.MEBS.patchmaker.source;

import gnnt.MEBS.patchmaker.PatchException;

/*******************************************************************
 * SimpleStringSource.java 2017年9月8日
 * <p>
 * class desc: 固定字符串Source
 * </p>
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * 
 * @author:ZhouPeng
 * 
 ******************************************************************/
public class SimpleStringSource implements ISource {

	/**
	 * 字符串源
	 */
	public String source;

	public SimpleStringSource(String source) {
		this.source = source;
	}

	@Override
	public String getSourceString() throws PatchException {
		return source;
	}

}
