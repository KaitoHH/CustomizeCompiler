package Syntax.AST.Basic;

import Lexer.Token.Token;
import Syntax.AST.Env;
import Syntax.AST.Type;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/24
 * Description:
 * All rights reserved.
 */
public class Bool extends Basic{
    public final boolean val;
    public Bool(Token token, boolean val) { super(token, Type.Bool); this.val = val;}

    @Override
    public double val() {
        // should not be called, okay, a bad smell in design
        return 0;
    }

    @Override
    public Basic eval(Env env) {
        return this;
    }

    @Override
    public String toJava() {
        return val ? "true" : "false";
    }
}
