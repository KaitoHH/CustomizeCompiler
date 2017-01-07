package CodeGenerator;

import Syntax.AST.Env;
import Syntax.AST.Statements.Stmt;
import org.json.JSONObject;

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
		root.execute(new Env());
		root.getCoverage(info);
		JSONObject jsonObject = new JSONObject(info.getLine());
		System.out.println(jsonObject);
	}

	public static void main(String[] args) throws IOException {
		CoverageGenerator.generate(CCompiler.getRoot());
	}
}
