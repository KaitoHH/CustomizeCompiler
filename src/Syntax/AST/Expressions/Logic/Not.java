package Syntax.AST.Expressions.Logic;

import Lexer.Token.Token;
import Syntax.AST.Basic.Basic;
import Syntax.AST.Basic.Bool;
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
public class Not extends Expr {
    public Expr expr;
    public Not(Token token, Expr expr) { super(token, Type.Bool); this.expr = expr; }

    @Override
    public Basic eval(Env env) {
        Basic val = expr.eval(env);
        if (Type.numeric(val.type))
            error("type error");

        if (Basic.isTrue(val))
            return new Bool(null, false);
        else
            return new Bool(null, true);
    }

    @Override
    public String toJava() {
        return "(!"+ expr.toJava() + ")";
    }

    @Override
    public JSONObject toJSON() {
        JSONObject object = new JSONObject();
        object.put("token", token.toJSON());
        object.put("type", type == null ? "":type.name);
        object.put("expr1", expr.toJSON());
        object.put("exprType", "Not");
        return object;
    }
}
