package Syntax.AST.Statements;

import Syntax.AST.Env;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/25
 * Description:
 * All rights reserved.
 */
public class Stmts extends Stmt {
    public final Stmt first;
    public final Stmts rest;

    public Stmts(Stmt first, Stmts rest) { this.first = first; this.rest = rest; }

    @Override
    public void execute(Env env) {
        first.execute(env);
        if (rest != null)
            rest.execute(env);
    }

    @Override
    public String toJava() {
        return first.toJava() + (rest != null ? rest.toJava(): "");
    }
}
