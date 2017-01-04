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
public class Less extends Logic {
    public Less(Token token, Expr expr1, Expr expr2) { super(token, expr1, expr2); }

    @Override
    public Basic eval(Env env) {
        Basic left = expr1.eval(env);
        if (!Type.numeric(left.type))
            left.error("expect numeric but get bool");

        Basic right = expr2.eval(env);
        if (!Type.numeric(right.type))
            right.error("expect numeric but get bool");

        return new Bool(null, left.val() < right.val());
    }

    @Override
    public String toJava() {
        return "(" + expr1.toJava() + " < " + expr2.toJava() + ")";
    }

    @Override
    public JSONObject toJSON() {
        JSONObject object = toLogicJSON();
        object.put("exprType", "Less");
        return null;
    }
}
