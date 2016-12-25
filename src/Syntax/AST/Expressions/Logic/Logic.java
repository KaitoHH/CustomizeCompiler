package Syntax.AST.Expressions.Logic;

import Lexer.Token.Token;
import Syntax.AST.Expressions.Expr;
import Syntax.AST.Type;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/25
 * Description:
 * All rights reserved.
 */
public abstract class Logic extends Expr {
    public Expr expr1, expr2;
    public Logic(Token token, Expr expr1, Expr expr2) {
        super(token, Type.Bool);
        this.expr1 = expr1;
        this.expr2 = expr2;
    }
}
