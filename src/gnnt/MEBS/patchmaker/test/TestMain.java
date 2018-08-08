package gnnt.MEBS.patchmaker.test;

import gnnt.MEBS.patchmaker.GoogleDiffPatchMakerFactory;
import gnnt.MEBS.patchmaker.PatchException;
import gnnt.MEBS.patchmaker.output.FileOutput;
import gnnt.MEBS.patchmaker.source.FileSource;

public class TestMain {

	public static void main(String[] args) throws PatchException {
		String projectroot = System.getProperty("user.dir") + "\\TestCache";
		FileSource oldSource = new FileSource(projectroot + "\\oldversion");
		System.out.println("旧版本大小:" + oldSource.getSourceString().getBytes().length);
		FileSource newSource = new FileSource(projectroot + "\\newversion");
		System.out.println("新版本大小:" + newSource.getSourceString().getBytes().length);
		// String patch =
		// GoogleDiffPatchMakerFactory.getPatchMaker().getPatchString(oldSource,
		// newSource);
		// System.out.println("补丁大小:" + patch.getBytes().length);
		//
		// // 生成补丁文件
		// FileOutput patchOutput = new FileOutput(projectroot + "\\patch");
		// GoogleDiffPatchMakerFactory.getPatchMaker().createPatch(oldSource,
		// newSource, patchOutput);

		// 生成更新后文件
		FileSource patchSource = new FileSource(projectroot + "\\patch");
		FileOutput patchedOutput = new FileOutput(projectroot + "\\patched");
		GoogleDiffPatchMakerFactory.getPatchMaker().applyPatch(oldSource, patchSource, patchedOutput);
	}
}
