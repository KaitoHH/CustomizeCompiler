package CodeGenerator;

import Syntax.AST.Env;
import Syntax.AST.Statements.Stmt;
import Utils.FileUtils;

import java.io.IOException;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2017/1/9
 * Description:
 * All rights reserved.
 */
public class ExecGenerator implements Generator {
	@Override
	public void execute(String[] args) throws IOException {
		String filename = args[0];
		try {
			Stmt root = FileUtils.deserialAST(filename);
			root.execute(new Env());
			FileUtils.serialAST(root, filename);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getOption() {
		return "-exec";
	}

	@Override
	public int getArgsCnt() {
		return 0;
	}
}
