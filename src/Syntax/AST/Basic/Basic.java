package Syntax.AST.Basic;

import Lexer.Token.Token;
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
public abstract class Basic extends Expr {
    public Basic(Token token, Type type) { super(token, type); }
    public abstract double val();

    public static Basic makeResult(Type type, double result) {
        if (type == Type.Char)
            return new Char(null, (char)result);
        else if (type == Type.Int)
            return new Int(null, (int)result);
        else
            return new Real(null, result);
    }

    public static boolean isTrue(Basic basic) {
        return basic.type == Type.Bool && ((Bool)basic).val;
    }

    public static boolean isFalse(Basic basic) {
        return basic.type == Type.Bool && !((Bool)basic).val;
    }

    public static Basic getUninitialized(Type type) {
        Basic uninitialized;
        if (type == Type.Real)
            uninitialized = Real.Uninitialized;
        else if (type == Type.Int)
            uninitialized = Int.Uninitialized;
        else if (type == Type.Bool)
            uninitialized = Bool.Uninitialized;
        else
            uninitialized = Char.Uninitialized;
        return uninitialized;
    }

    @Override
    public abstract String toString();

    public JSONObject toBasicJSON() {
        JSONObject object = new JSONObject();
        object.put("token", token.toJSON());
        object.put("type", type == null ? "":type.name);
        return object;
    }
}
