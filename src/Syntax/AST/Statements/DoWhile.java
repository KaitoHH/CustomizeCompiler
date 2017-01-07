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
 * Create Date: 2016/12/29
 * Description:
 * All rights reserved.
 */
public class DoWhile extends Stmt{
    public final Expr expr;
    public final Stmt stmt;
    public DoWhile(Expr expr, Stmt stmt) {
        this.expr = expr;
        this.stmt = stmt;
        setLineNum(expr.token.getLineNum());
    }

    @Override
    public void execute(Env env) {
        setCalledNum(getCalledNum() + 1);
        stmt.execute(env);

        while(true) {
            Basic condition = expr.eval(env);
            if (Type.numeric(condition.type))
                expr.error("expect bool but get numeric");

            if (Basic.isFalse(condition))
                break;

            setCalledNum(getCalledNum() + 1);
            stmt.execute(env);
        }
    }

    @Override
    public String toJava() {
        return "do\n" +
                stmt.toJava() +
                "while(" + expr.toJava() + ");\n";
    }

    @Override
    public JSONObject toJSON() {
        JSONObject object = new JSONObject();
        object.put("expr", expr.toJSON());
        object.put("stmt", stmt.toJSON());
        object.put("stmtType", "DoWhile");
        return object;
    }

    @Override
    public void getCoverage(CoverageInfo info) {
        stmt.getCoverage(info);
        info.set(getLineNum(),getCalledNum());
    }
}
