package Syntax.AST.Expressions;

import Lexer.Token.Token;
import Syntax.AST.Basic.Basic;
import Syntax.AST.Env;
import Syntax.AST.Type;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/24
 * Description:
 * All rights reserved.
 */
public abstract class Expr{
    public Type type;
    public Token token;
    public Expr(Token token, Type type) { this.token = token; this.type = type;  }
    public void error(String msg) {
        if (token == null)
            throw new RuntimeException("Try to throw exception on temp value, msg: " + msg);
        else
            throw new RuntimeException("Runtime error occurs at line " + token.lineNum + " offset " + token.lineOffset + "," + msg);
    }

    public abstract Basic eval(Env env) throws RuntimeException;
    public abstract String toJava();
}
