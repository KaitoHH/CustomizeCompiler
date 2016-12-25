package Syntax.AST.Expressions.Arith;

import Lexer.Token.Token;
import Syntax.AST.Basic.Basic;
import Syntax.AST.Env;
import Syntax.AST.Expressions.Expr;

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

        return Basic.makeResult(this, type, -1 * right.val());
    }
}
