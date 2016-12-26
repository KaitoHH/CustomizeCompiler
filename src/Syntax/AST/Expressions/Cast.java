package Syntax.AST.Expressions;

import Lexer.Token.Token;
import Syntax.AST.Basic.Basic;
import Syntax.AST.Basic.Bool;
import Syntax.AST.Basic.Int;
import Syntax.AST.Basic.Real;
import Syntax.AST.Env;
import Syntax.AST.Type;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/26
 * Description:
 * All rights reserved.
 */
public class Cast extends Expr{
    public final Expr expr;
    public Cast(Token token, Type type, Expr expr) { super(token, type); this.expr = expr; }

    @Override
    public Basic eval(Env env) throws RuntimeException {
        Basic right = expr.eval(env);
        if (type == right.type)
            return right;
        else if (type == Type.Bool)
            return new Bool(null, right.val() != 0);
        else if (right.type == Type.Bool) {
            // bool - > numeric
            if (type == Type.Int)
                return new Int(null, Basic.isTrue(right)? 1 : 0);
            else
                return new Real(null, Basic.isTrue(right)? 1 : 0);
        } else {
            // numeric -> numeric
            if (type == Type.Int)
                return new Int(null, (int)right.val());
            else
                return new Real(null, right.val());
        }
    }
}
