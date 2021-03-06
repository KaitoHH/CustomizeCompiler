package Syntax.AST.Statements;

import CodeGenerator.CoverageInfo;
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
        setLineNum(expr.token.getLineNum());
    }

    @Override
    public void execute(Env env) {
        setCalledNum(getCalledNum() + 1);
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

    @Override
    public String toJava() {
        return "if(" + expr.toJava() + ")\n" +
                (newScope? new Scope(stmt1).toJava(): stmt1.toJava()) +
                (stmt2 == null? "" : "else" +
                        (stmt2 instanceof If ? " "  + stmt2.toJava(): "\n" + stmt2.toJava()));
    }

    @Override
    public JSONObject toJSON() {
        JSONObject object = new JSONObject();
        object.put("expr", expr.toJSON());
        object.put("stmt1", stmt1.toJSON());
        if (stmt2 != null)
        object.put("stmt2", stmt2.toJSON());
        object.put("stmtType", "If");
        return object;
    }

    @Override
    public void getCoverage(CoverageInfo info) {
        info.set(getLineNum(),getCalledNum());
        stmt1.getCoverage(info);
        stmt2.getCoverage(info);
    }
}
