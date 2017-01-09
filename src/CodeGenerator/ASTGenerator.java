package CodeGenerator;

import Lexer.Lexer;
import Syntax.AST.ASTRoot;
import Syntax.AST.Statements.Stmt;
import Syntax.Parser;
import Syntax.SyntaxParser;
import Syntax.SyntaxScanner;
import Utils.FileUtils;

import java.io.IOException;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2017/1/9
 * Description:
 * All rights reserved.
 */
public class ASTGenerator implements Generator {
	@Override
	public void execute(String[] args) throws IOException {
		String filename = args[0];
		Stmt root = getRoot(filename);
		FileUtils.serialAST(root, FileUtils.replaceExtName(filename, "ast"));
	}

	@Override
	public String getOption() {
		return null;
	}

	@Override
	public int getArgsCnt() {
		return 0;
	}

	public static Stmt getRoot(String filename) throws IOException {
		Lexer lexer = new Lexer(FileUtils.getFileString(filename));
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
}
