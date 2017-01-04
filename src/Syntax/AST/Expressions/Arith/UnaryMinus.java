package Syntax.AST.Expressions.Arith;

import Lexer.Token.Token;
import Syntax.AST.Basic.Basic;
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
public class UnaryMinus extends Expr {
    public Expr expr;
    public UnaryMinus(Token token, Expr expr) { super(token, expr.type); this.expr = expr; }

    @Override
    public Basic eval(Env env) {
        Basic right = expr.eval(env);
        type = right.type;

        if (type == Type.Char)
            type = Type.Int;
        return Basic.makeResult(type, -1 * right.val());
    }

    @Override
    public String toJava() {
        return "(-" + expr.toJava() + ")";
    }

    @Override
    public JSONObject toJSON() {
        JSONObject object = new JSONObject();
        object.put("token", token.toJSON());
        object.put("type", type == null ? "":type.name);
        object.put("expr1", expr.toJSON());
        object.put("exprType","UnaryMinus");
        return object;
    }
}
