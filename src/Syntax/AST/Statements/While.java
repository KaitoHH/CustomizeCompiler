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
public class While extends Stmt{
    public final Expr expr;
    public final Stmt stmt;
    public final boolean newScope;
    public While(Expr expr, Stmt stmt, boolean newScope) { this.expr = expr; this.stmt = stmt; this.newScope = newScope; }

    @Override
    public void execute(Env env) {
        while(true) {
            Basic condition = expr.eval(env);
            if (Type.numeric(condition.type))
                expr.error("type error");

            if (Basic.isFalse(condition))
                break;

            if (newScope)
                new Scope(stmt).execute(env);
            else
                stmt.execute(env);
        }
    }
}
