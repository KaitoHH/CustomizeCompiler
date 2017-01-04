package Syntax.AST.Statements;

import Syntax.AST.Basic.Basic;
import Syntax.AST.Env;
import Syntax.AST.Expressions.Expr;
import org.json.JSONObject;

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
    public String toJava() {
        return "System.out.print(" + expr.toJava() + ");\n";
    }

    @Override
    public JSONObject toJSON() {
        JSONObject object = new JSONObject();
        object.put("expr1", expr.toJSON());
        object.put("stmtType", "Print");
        return object;
    }
}
