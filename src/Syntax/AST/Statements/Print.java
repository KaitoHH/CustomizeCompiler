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
    private static boolean disabled;
    public final Expr expr;
    public Print(Expr expr) { this.expr = expr; setLineNum(expr.token.getLineNum());}

    @Override
    public void execute(Env env) {
        setCalledNum(getCalledNum() + 1);
        Basic val = expr.eval(env);
        if (!disabled)
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

    public static void disable() { disabled = true; }
    public static void enable() { disabled = false; }
}
