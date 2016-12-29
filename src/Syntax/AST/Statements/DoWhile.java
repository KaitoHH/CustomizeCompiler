package Syntax.AST.Statements;

import Syntax.AST.Basic.Basic;
import Syntax.AST.Env;
import Syntax.AST.Expressions.Expr;
import Syntax.AST.Type;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/29
 * Description:
 * All rights reserved.
 */
public class DoWhile extends Stmt{
    public final Expr expr;
    public final Stmt stmt;
    public DoWhile(Expr expr, Stmt stmt) { this.expr = expr; this.stmt = stmt; }

    @Override
    public void execute(Env env) {
        stmt.execute(env);

        while(true) {
            Basic condition = expr.eval(env);
            if (Type.numeric(condition.type))
                expr.error("expect bool but get numeric");

            if (Basic.isFalse(condition))
                break;

            stmt.execute(env);
        }
    }

    @Override
    public String toJava(String indent) {
        return indent + "do\n" +
                stmt.toJava(indent) +
                "while(" + expr.toJava() + ");\n";
    }
}
