package Syntax.AST.Expressions.Arith;

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
public abstract class Arith extends Expr {
    public Expr expr1, expr2;
    public Arith(Token token, Type type, Expr expr1, Expr expr2) {
        super(token, type);
        this.expr1 = expr1;
        this.expr2 = expr2;
    }
}
