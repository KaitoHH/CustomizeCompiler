package CodeGenerator;

import Syntax.AST.Statements.Stmt;
import Utils.FileUtils;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2017/1/4
 * Description:
 * All rights reserved.
 */
public class JSONGenerator implements Generator {
	public static JSONObject generate(Stmt root) {
		return root.toJSON();
	}


	@Override
	public void execute(String[] args) throws IOException {
		String filename = args[1];
		try {
			Stmt root = FileUtils.deserialAST(filename);
			String string = JSONGenerator.generate(root).toString();
			FileUtils.createFile(args[0], string);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String getOption() {
		return "-json";
	}

	@Override
	public int getArgsCnt() {
		return 1;
	}
}
