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
public abstract class Expr {
    public Type type;
    public Token token;
    public Expr(Token token, Type type) { this.token = token; this.type = type;  }
    public void error(String msg) { System.out.println(msg); }
    public abstract Basic eval(Env env);
}
