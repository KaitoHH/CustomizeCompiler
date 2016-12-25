package Syntax.AST.Expressions.Arith;

import Lexer.Token.Token;
import Syntax.AST.Basic.Basic;
import Syntax.AST.Env;
import Syntax.AST.Expressions.Expr;
import Syntax.AST.Type;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/24
 * Description:
 * All rights reserved.
 */
public class Times extends Arith {
    public Times(Token token, Type type, Expr expr1, Expr expr2) { super(token, type, expr1, expr2); }

    @Override
    public Basic eval(Env env) {
        Basic left = expr1.eval(env);
        Basic right = expr2.eval(env);

        type = Type.max(left.type, right.type);
        if (type == null) error("type error");

        return Basic.makeResult(this, type, left.val() * right.val());
    }
}
