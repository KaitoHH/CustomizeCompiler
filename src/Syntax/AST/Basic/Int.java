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
public class Int extends Basic{
    public final int val;
    public Int(Token token, int val) { super(token, Type.Int); this.val = val; }

    @Override
    public double val() {
        return val;
    }

    @Override
    public Basic eval(Env env) {
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    @Override
    public String toJava() {
        return toString();
    }

    @Override
    public JSONObject toJSON() {
        JSONObject object = toBasicJSON();
        object.put("val", val);
        object.put("exprType", "Int");
        return object;
    }

    public static final Basic Uninitialized = new Int(null, Integer.MIN_VALUE);
}
