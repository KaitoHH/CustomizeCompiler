package CodeGenerator;

import Syntax.AST.Env;
import Syntax.AST.Statements.Print;
import Syntax.AST.Statements.Stmt;

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
public class CoverageGenerator {
	public static void generate(Stmt root) {
		CoverageInfo info = new CoverageInfo();
		Print.disable();
		root.execute(new Env());
		root.getCoverage(info);
		System.out.println(info.toJSON());
	}

	public static void main(String[] args) throws IOException {
		CoverageGenerator.generate(CCompiler.getRoot());
	}
}
