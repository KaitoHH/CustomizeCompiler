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
public class Real extends Basic {
    public final double val;
    public Real(Token token, double val) { super(token, Type.Real); this.val = val; }

    @Override
    public double val() {
        return val;
    }

    @Override
    public Basic eval(Env env) {
        return this;
    }

    @Override
    public String toJava() {
        return String.valueOf(val);
    }
}
