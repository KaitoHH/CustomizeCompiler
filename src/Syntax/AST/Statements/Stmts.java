package Syntax.AST.Statements;

import Syntax.AST.Env;
import org.json.JSONObject;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/25
 * Description:
 * All rights reserved.
 */
public class Stmts extends Stmt {
    public final Stmt first;
    public final Stmts rest;
    private int lineNum;
    private int calledNum;

    public Stmts(Stmt first, Stmts rest) { this.first = first; this.rest = rest; }

    public int getLineNum() { return lineNum; }
    public int getCalledNum() {return calledNum; }

    @Override
    public void execute(Env env) {
        first.execute(env);
        if (rest != null)
            rest.execute(env);
    }

    @Override
    public String toJava() {
        return first.toJava() + (rest != null ? rest.toJava(): "");
    }

    @Override
    public JSONObject toJSON() {
        JSONObject object = new JSONObject();
        object.put("left", first.toJSON());
        object.put("stmtType", "Stmts");

        if (rest != null)
            object.put("right", rest.toJSON());
        return object;
    }
}
