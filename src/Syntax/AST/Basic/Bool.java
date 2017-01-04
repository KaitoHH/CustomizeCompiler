package Syntax.AST.Basic;

import Lexer.Token.Token;
import Syntax.AST.Env;
import Syntax.AST.Type;
import org.json.JSONObject;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/24
 * Description:
 * All rights reserved.
 */
public class Bool extends Basic{
    public final boolean val;
    public Bool(Token token, boolean val) { super(token, Type.Bool); this.val = val;}

    @Override
    public double val() {
        // should not be called, okay, a bad smell in design
        return 0;
    }

    @Override
    public Basic eval(Env env) {
        return this;
    }

    @Override
    public String toString() {
        return val ? "true" : "false";
    }

    @Override
    public String toJava() {
        return toString();
    }

    @Override
    public JSONObject toJSON() {
        JSONObject object = toBasicJSON();
        object.put("val", val);
        object.put("exprType", "Bool");
        return object;
    }

    public static final Basic Uninitialized = new Bool(null, false);
}
