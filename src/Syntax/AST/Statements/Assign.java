package Syntax.AST.Statements;

import Syntax.AST.Basic.Basic;
import Syntax.AST.Basic.Id;
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
public class Assign extends Stmt {
    public final Id id;
    public final Expr expr;
    public Assign(Id id, Expr expr) { this.id = id; this.expr = expr; setLineNum(id.token.getLineNum()); }

    @Override
    public void execute(Env env) {
        setCalledNum(getCalledNum() + 1);
        if (env.get(id) == null)
            id.error("assign to undeclared identifier");

        Basic right = expr.eval(env);
        Basic left = env.get(id);
        if (!Type.assignable(left.type, right.type))
            id.error("can not assign " + right.type.name +" to type " + left.type.name);

        env.update(id, Basic.makeResult(Type.max(left.type, right.type), right.val()));
    }

    @Override
    public String toJava() {
        return id.name + " = " + expr.toJava() + ";\n";
    }

    @Override
    public JSONObject toJSON() {
        JSONObject object = new JSONObject();
        object.put("id", id.toJSON());
        object.put("expr", expr.toJSON());
        object.put("stmtType", "Assign");
        return object;
    }
}
