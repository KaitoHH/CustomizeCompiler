package CodeGenerator;

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
public class CCompiler {

	public static Stmt getRoot() throws IOException {
		Lexer lexer = new Lexer(FileUtils.getFileString("source.txt"));
		SyntaxScanner scanner = new SyntaxScanner(lexer.getTokenList());
		Parser p = new SyntaxParser(scanner, scanner.getFactory());
		try {
			p.parse();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Compile terminated due to Syntax Error");
			return null;
		}
		//AST
		return ASTRoot.getRoot();
	}

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		Stmt root = getRoot();
		FileUtils.serialAST(root,"fib.ast");
		Stmt stmt = FileUtils.deserialAST("fib.ast");
		System.out.println(JavaGenerator.generate(stmt));
		System.out.println(JSONGenerator.generate(stmt));
		stmt.execute(new Env());
		//root.execute(new Env());
	}

}
