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
public class UnEqual extends Logic {
    public UnEqual(Token token, Expr expr1, Expr expr2) { super(token, expr1, expr2); }

    @Override
    public Basic eval(Env env) {
        Basic left = expr1.eval(env);
        Basic right = expr2.eval(env);

        Type maxType = Type.max(left.type, right.type);
        if (maxType == null)
            error("left and right type not match");

        if (Type.numeric(left.type))
            return new Bool(null, left.val() != right.val());
        else
            return new Bool(null, Basic.isTrue(left) && Basic.isFalse(right) || Basic.isFalse(left) && Basic.isTrue(right));
    }

    @Override
    public String toJava() {
        return "(" + expr1.toJava() + " != " + expr2.toJava() + ")";
    }

    @Override
    public JSONObject toJSON() {
        JSONObject object = toLogicJSON();
        object.put("exprType", "UnEqual");
        return null;
    }
}
