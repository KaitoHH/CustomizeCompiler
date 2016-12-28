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
public class Id extends Expr {
    public String name;

    public Id(Token token, Type type, String name) { super(token, type); this.name = name;}

    @Override
    public Basic eval(Env env) {
        return env.get(this);
    }

    @Override
    public String toJava() {
        return name;
    }
}
