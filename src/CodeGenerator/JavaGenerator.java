package CodeGenerator;

import Syntax.AST.Statements.Stmt;
import Utils.FileUtils;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/28
 * Description:
 * All rights reserved.
 */
public class JavaGenerator implements Generator{
	public static String generate(Stmt root) {
		return "public class Main  {\n" +
				"    public static void main(String arg[]) throws IOException{ \n" +
				addIndent(root.toJava()) +
				"    }\n}";
	}

	public static String addIndent(String input) {
		String indentedCode = "";
		String[] lines = input.split("\n");
		int indent = 8;
		String scopeStart = "\\s*\\{\\s*$";
		String scopeEnd = "\\s*\\}\\s*$";

		for (String line : lines) {
			if (Pattern.matches(scopeEnd, line))
				indent -= 4;

			indentedCode += getIndent(indent) + line + "\n";

			if (Pattern.matches(scopeStart, line))
				indent += 4;

		}
		return indentedCode;
	}

	public static String getIndent(int indent) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < indent; i++)
			sb.append(' ');
		return sb.toString();
	}

	@Override
	public void execute(String[] args) throws IOException {
		String filename = args[1];
		try {
			Stmt root = FileUtils.deserialAST(filename);
			String string = generate(root);
			FileUtils.createFile(args[0], string);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getOption() {
		return "-tojava";
	}

	@Override
	public int getArgsCnt() {
		return 1;
	}
}
