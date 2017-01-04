import CodeGenerator.JSONGenerator;
import CodeGenerator.JavaGenerator;
import Lexer.Lexer;
import Syntax.AST.ASTRoot;
import Syntax.AST.Env;
import Syntax.AST.Statements.Stmt;
import Syntax.AST.Statements.Stmts;
import Syntax.Parser;
import Syntax.SyntaxParser;
import Syntax.SyntaxScanner;
import Utils.FileUtils;

import java.io.IOException;
import java.util.Scanner;

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
		}
		//AST
		Stmt root = ASTRoot.getRoot();

		//execute or generate
		root.execute(new Env());
		System.out.println(JavaGenerator.generate(root));
		System.out.println(JSONGenerator.generate(root).toString());
		startREPL();
	}

	public static void startREPL() {
		System.out.print(inputPrompt);
		while(true) {
			String input = new Scanner(System.in).useDelimiter("#").next();

			if ("quit".equals(input))
				break;
			if ("getJavaCode".equals(input)) {
				System.out.println(JavaGenerator.generate(root));
				System.out.println();
				System.out.print(inputPrompt);
				continue;
			}
			if ("clear".equals(input)) {
				root = null;
				env = new Env();

				System.out.println();
				System.out.print(inputPrompt);
				continue;
			}

			try {
				Lexer lexer = new Lexer(input);
				SyntaxScanner scanner = new SyntaxScanner(lexer.getTokenList());
				Parser p = new SyntaxParser(scanner, scanner.getFactory());
				p.parse();
				Stmt inputStmt = ASTRoot.getRoot();
				inputStmt.execute(env);

				if (root == null)
					root = inputStmt;
				else
					root = new Stmts(root, new Stmts(inputStmt, null));
			} catch (IOException e) {
				System.out.println("Missing config file:");
				System.out.println(e.getMessage());
			} catch (RuntimeException e) {
				System.out.println("Error occurs during execution:");
				System.out.println(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println();
			System.out.print(inputPrompt);
		}
	}
}
