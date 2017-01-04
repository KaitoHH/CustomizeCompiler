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
public class Real extends Basic {
    public final double val;
    public Real(Token token, double val) { super(token, Type.Real); this.val = val; }

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
        object.put("exprType", "Real");
        return object;
    }

    public static final Basic Uninitialized = new Real(null, Double.MIN_VALUE);
}
