package CodeGenerator;

import Syntax.AST.Statements.Stmt;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2017/1/4
 * Description:
 * All rights reserved.
 */
public class JSONGenerator {
	public static JSONObject generate(Stmt root) {
		return root.toJSON();
	}

	public static void main(String[] args) throws IOException {
		System.out.println(JSONGenerator.generate(CCompiler.getRoot()).toString());
	}
}
