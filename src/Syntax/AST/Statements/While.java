package Syntax.AST.Statements;

import Syntax.AST.Basic.Basic;
import Syntax.AST.Env;
import Syntax.AST.Expressions.Expr;
import Syntax.AST.Type;
import org.json.JSONObject;

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
                expr.error("expect bool but get numeric");

            if (Basic.isFalse(condition))
                break;

            if (newScope)
                new Scope(stmt).execute(env);
            else
                stmt.execute(env);
        }
    }

    @Override
    public String toJava() {
        return "while(" + expr.toJava() + ")\n" +
                (newScope? new Scope(stmt).toJava(): stmt.toJava());
    }

    @Override
    public JSONObject toJSON() {
        JSONObject object = new JSONObject();
        object.put("expr", expr.toJSON());
        object.put("stmt", stmt.toJSON());
        object.put("stmtType", "While");
        return object;
    }
}
