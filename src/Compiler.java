import CodeGenerator.JSONGenerator;
import CodeGenerator.JavaGenerator;
import Lexer.Lexer;
import Syntax.AST.ASTRoot;
import Syntax.AST.Env;
import Syntax.AST.Statements.Stmt;
import Syntax.Parser;
import Syntax.SyntaxParser;
import Syntax.SyntaxScanner;
import Utils.FileUtils;

import java.io.IOException;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2017/1/3
 * Description:
 * All rights reserved.
 */
public class Compiler {
	public static String inputPrompt = ">>>";
	public static Stmt root;
	public static Env env = new Env();

	public static void main(String args[]) throws IOException {
		Lexer lexer = new Lexer(FileUtils.getFileString("source.txt"));
		SyntaxScanner scanner = new SyntaxScanner(lexer.getTokenList());
		Parser p = new SyntaxParser(scanner, scanner.getFactory());
		try {
			p.parse();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Compile terminated due to Syntax Error");
			return;
		}
		//AST
		Stmt root = ASTRoot.getRoot();

		//execute or generate
		root.execute(new Env());
		System.out.println("\n");
		System.out.println(JavaGenerator.generate(root));
		System.out.println(JSONGenerator.generate(root).toString());
	}

}
