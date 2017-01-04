package Syntax.AST.Basic;

import Lexer.Token.Token;
import Syntax.AST.Env;
import Syntax.AST.Expressions.Expr;
import Syntax.AST.Type;
import org.json.JSONObject;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/24
 * Description:
 * All rights reserved.
 */
public class Id extends Expr {
    public String name;

    public Id(Token token, Type type, String name) { super(token, type); this.name = name;}

    @Override
    public Basic eval(Env env) {
        Basic val = env.get(this);
        if (val != null && Basic.getUninitialized(val.type) == val)
            error("try to use uninitialized identifier");
        return env.get(this);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String toJava() {
        return toString();
    }

    public JSONObject toJSON() {
        JSONObject object = new JSONObject();
        object.put("token", token.toJSON());
        object.put("type", type == null ? "":type.name);
        object.put("name", name);
        object.put("exprType", "Id");
        return object;
    }
}
