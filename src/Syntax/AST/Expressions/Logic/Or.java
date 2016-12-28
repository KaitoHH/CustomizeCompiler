package Syntax.AST.Expressions.Logic;

import Lexer.Token.Token;
import Syntax.AST.Basic.Basic;
import Syntax.AST.Env;
import Syntax.AST.Expressions.Expr;
import Syntax.AST.Type;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/25
 * Description:
 * All rights reserved.
 */
public class Or extends Logic {
    public Or(Token token, Expr expr1, Expr expr2) { super(token, expr1, expr2); }

    @Override
    public Basic eval(Env env) {
        Basic left = expr1.eval(env);
        if (Type.numeric(left.type))
            left.error("expect bool but get numeric");

        if (Basic.isTrue(left))
            return left;

        Basic right = expr2.eval(env);
        if (Type.numeric(left.type))
            left.error("expect bool but get numeric");
        return right;
    }

    @Override
    public String toJava() {
        return "(" + expr1.toJava() + " || " + expr2.toJava() + ")";
    }
}
