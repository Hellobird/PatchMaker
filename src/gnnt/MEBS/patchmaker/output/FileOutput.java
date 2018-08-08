package gnnt.MEBS.patchmaker.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import gnnt.MEBS.patchmaker.PatchException;

/*******************************************************************
 * FileOutput.java 2017年9月7日
 * <p>
 * class desc:文件输出类
 * </p>
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * 
 * @author:ZhouPeng
 * 
 ******************************************************************/
public class FileOutput implements IOutput {

	String outputPath;

	public FileOutput(String path) {
		this.outputPath = path;
	}

	@Override
	public boolean outputPatchedContent(String content) throws PatchException {
		boolean result = false;
		if (content == null || content.length() == 0) {
			throw new PatchException("待输出内容为空");
		}
		File file = new File(outputPath);
		try {
			if (!file.exists() && !file.createNewFile()) {
				throw new PatchException("创建文件失败");
			}
		} catch (IOException e) {
			throw new PatchException("创建文件失败，错误：" + e.getMessage());
		}

		FileOutputStream fileOutputStream = null;
		OutputStreamWriter outputStreamWriter = null;

		try {
			fileOutputStream = new FileOutputStream(file, false);
			outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
			outputStreamWriter.write(content);
			outputStreamWriter.flush();
			result = true;
		} catch (Exception e) {
			throw new PatchException("写入文件失败，错误类型:" + e.getClass().getSimpleName() + ",错误原因:" + e.getMessage());
		} finally {
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (Exception e) {
				}
			}
			if (outputStreamWriter != null) {
				try {
					outputStreamWriter.close();
				} catch (Exception e) {
				}
			}
		}
		return result;
	}

}
