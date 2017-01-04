package Syntax.AST.Statements;

import Syntax.AST.Basic.*;
import Syntax.AST.Env;
import Syntax.AST.Type;
import org.json.JSONObject;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/25
 * Description:
 * All rights reserved.
 */
public class Declare extends Stmt{
    public final Id id;
    public Declare(Id id) { this.id = id; }

    @Override
    public void execute(Env env) {
        if (env.getWithinCurEnv(id) != null)
            id.error("duplicate declare");

        env.put(id, Basic.getUninitialized(id.type));
    }

    @Override
    public String toJava() {
        return Type.toJavaType(id.type) + " " + id.name + ";\n";
    }

    @Override
    public JSONObject toJSON() {
        JSONObject object = new JSONObject();
        object.put("id", id.toJSON());
        object.put("stmtType", "Declare");
        return object;
    }
}
