package Syntax.AST.Statements;

import Syntax.AST.Basic.Basic;
import Syntax.AST.Basic.Id;
import Syntax.AST.Env;
import Syntax.AST.Expressions.Expr;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/25
 * Description:
 * All rights reserved.
 */
public class Assign extends Stmt {
    public final Id id;
    public final Expr expr;
    public Assign(Id id, Expr expr) { this.id = id; this.expr = expr; }

    @Override
    public void execute(Env env) {
        if (env.get(id) == null)
            id.error("assign to undeclared identifier");

        Basic right = expr.eval(env);
        if (id.type != right.type)
            id.error("left and right type not match");

        env.update(id, right);
    }
}
