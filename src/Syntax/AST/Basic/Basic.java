package Syntax.AST.Basic;

import Lexer.Token.Token;
import Syntax.AST.Expressions.Expr;
import Syntax.AST.Type;

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

    public static Basic makeResult(Expr op, Type type, double result) {
        if (!Type.numeric(type))
            op.error("type error");

        if (type == Type.Int)
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

    @Override
    public abstract String toString();

    public static final Basic Uninitialized = new Int(null, Integer.MIN_VALUE);
}
