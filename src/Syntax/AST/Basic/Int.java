package Syntax.AST.Basic;

import Lexer.Token.Token;
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
public class Int extends Basic{
    public final int val;
    public Int(Token token, int val) { super(token, Type.Int); this.val = val; }

    @Override
    public double val() {
        return val;
    }

    @Override
    public Basic eval(Env env) {
        return this;
    }
}
