package Syntax.AST.Statements;

import Syntax.AST.Basic.Id;
import Syntax.AST.Env;
import org.json.JSONObject;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/26
 * Description:
 * All rights reserved.
 */
public class UnDeclare extends Stmt {
    public final Id id;
    public UnDeclare(Id id) { this.id = id; setLineNum(id.token.getLineNum()); }

    @Override
    public void execute(Env env) {
        setCalledNum(getCalledNum() + 1);
        env.undeclare(id);
    }

    @Override
    public String toJava() {
        return "\\\\ unDeclare not supported in java \n";
    }

    @Override
    public JSONObject toJSON() {
        JSONObject object = new JSONObject();
        object.put("id", id.toJSON());
        object.put("stmtType", "UnDeclare");
        return object;
    }
}
