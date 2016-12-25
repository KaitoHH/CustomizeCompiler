package Syntax.AST.Statements;

import Syntax.AST.Env;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/25
 * Description:
 * All rights reserved.
 */
public class Scope extends Stmt {
    public Stmt stmt;
    public Scope(Stmt stmt) { this.stmt = stmt; }

    @Override
    public void execute(Env env) {
        stmt.execute(env.createInner());
    }
}
