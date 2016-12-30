package Syntax.AST.Statements;

import Syntax.AST.Basic.Basic;
import Syntax.AST.Env;
import Syntax.AST.Expressions.Expr;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/30
 * Description:
 * All rights reserved.
 */
public class Print extends Stmt {
    public final Expr expr;
    public Print(Expr expr) { this.expr = expr; }

    @Override
    public void execute(Env env) {
        Basic val = expr.eval(env);
        System.out.print(val.toString());
    }

    @Override
    public String toJava(String indent) {
        return indent + " System.out.print(" + expr.toJava() + ")";
    }
}
