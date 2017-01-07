package Syntax.AST.Statements;

import CodeGenerator.CoverageInfo;
import Syntax.AST.Env;
import org.json.JSONObject;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/25
 * Description:
 * All rights reserved.
 */
public class Scope extends Stmt {
    public Stmt stmt;
    public Scope(Stmt stmt) { this.stmt = stmt; }

    @Override
    public void execute(Env env) {
        stmt.execute(env.createInner());
    }

    @Override
    public String toJava() {
        return "{\n" +
                stmt.toJava() +
                "}\n";
    }

    @Override
    public JSONObject toJSON() {
        JSONObject object = new JSONObject();
        object.put("stmt", stmt.toJSON());
        object.put("stmtType", "Print");
        return object;
    }

    @Override
    public void getCoverage(CoverageInfo info) {
        stmt.getCoverage(info);
    }
}
