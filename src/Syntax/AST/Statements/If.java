package Syntax.AST.Statements;

import Syntax.AST.Basic.Basic;
import Syntax.AST.Env;
import Syntax.AST.Expressions.Expr;
import Syntax.AST.Type;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/25
 * Description:
 * All rights reserved.
 */
public class If extends Stmt{
    public final Expr expr;
    public final Stmt stmt1;
    public final Stmt stmt2;
    public final boolean newScope;
    public If(Expr expr, Stmt stmt1, Stmt stmt2, boolean newScope) {
        this.expr = expr;
        this.stmt1 = stmt1;
        this.stmt2 = stmt2;
        this.newScope = newScope;
    }

    @Override
    public void execute(Env env) {
        Basic condition = expr.eval(env);
        if (Type.numeric(condition.type))
            expr.error("expect bool but get numeric");

        if (Basic.isTrue(condition)) {
            if (stmt1 != null)
                stmt1.execute(env);
        } else {
            if (stmt2 != null)
                stmt2.execute(env);
        }
    }
}
