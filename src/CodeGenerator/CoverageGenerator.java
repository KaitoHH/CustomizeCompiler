package CodeGenerator;

import Syntax.AST.Statements.Stmt;
import Utils.FileUtils;

import java.io.IOException;

/**
 * Project: CustomizeCompiler
 * Package: CodeGenerator
 * Create Date: 2017/1/7
 * All rights reserved 2017
 *
 * @author huang
 * @version 1.0
 */
public class CoverageGenerator implements Generator {
	public static String generate(Stmt root) {
		CoverageInfo info = new CoverageInfo();
		root.getCoverage(info);
		return info.toJSON().toString();
	}

	@Override
	public void execute(String[] args) throws IOException {
		String filename = args[0];
		try {
			Stmt root = FileUtils.deserialAST(FileUtils.replaceExtName(filename,"ast"));
			String string = generate(root);
			FileUtils.createFile(filename + ".json", string);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getOption() {
		return "-showcoverage";
	}

	@Override
	public int getArgsCnt() {
		return 0;
	}
}
