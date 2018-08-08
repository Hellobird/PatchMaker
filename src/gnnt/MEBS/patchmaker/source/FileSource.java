package gnnt.MEBS.patchmaker.source;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import gnnt.MEBS.patchmaker.PatchException;

/*******************************************************************
 * FileSource.java 2017年9月7日
 * <p>
 * class desc:文件源数据
 * </p>
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * 
 * @author:ZhouPeng
 * 
 ******************************************************************/
public class FileSource implements ISource {
	/**
	 * 文件路径
	 */
	public String path;

	/**
	 * 文件源构造方法
	 * 
	 * @param path
	 *            文件路径
	 */
	public FileSource(String path) {
		this.path = path;
	}

	@Override
	public String getSourceString() throws PatchException {
		String result = null;
		File file = new File(path);
		// 判断文件是否存在
		if (file.exists()) {
			FileReader fileReader = null;
			BufferedReader bufferedReader = null;
			try {
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				StringBuffer stringBuffer = new StringBuffer();
				String temp;
				while ((temp = bufferedReader.readLine()) != null) {
					stringBuffer.append(temp);
					stringBuffer.append("\n");
				}
				result = stringBuffer.toString();
				if (result == null || result.length() == 0) {
					throw new PatchException("读取文件源为空，请检查配置是否正确");
				}
			} catch (Exception e) {
				throw new PatchException("读取文件失败，异常类型:" + e.getClass().getSimpleName() + "，异常信息:" + e.getMessage());
			} finally {
				if (fileReader != null) {
					try {
						fileReader.close();
					} catch (IOException e) {
					}
				}
				if (bufferedReader != null) {
					try {
						bufferedReader.close();
					} catch (IOException e) {
					}
				}
			}
		} else {
			throw new PatchException("读取文件失败，未找到" + path);
		}
		return result;
	}

}
