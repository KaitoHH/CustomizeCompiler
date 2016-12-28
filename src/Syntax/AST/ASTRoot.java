package Syntax.AST;

import Syntax.AST.Statements.Stmt;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/12/28
 * Description:
 * All rights reserved.
 */
public class ASTRoot {
	private static Stmt root;

	public static void setRoot(Stmt stmt) {
		root = stmt;
	}

	public static Stmt getRoot() {
		return root;
	}
}
