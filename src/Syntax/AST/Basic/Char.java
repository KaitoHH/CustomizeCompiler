package Syntax.AST.Basic;

import Lexer.Token.Token;
import Syntax.AST.Env;
import Syntax.AST.Type;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/30
 * Description:
 * All rights reserved.
 */
public class Char extends Basic {
    public final char c;
    public Char(Token token, char c) { super(token, Type.Char); this.c = c; }

    @Override
    public Basic eval(Env env) throws RuntimeException { return this; }

    @Override
    public double val() { return (double)c; }

    @Override
    public String toString() { return String.valueOf(c); }

    @Override
    public String toJava() { return toString(); }

    public static final Basic Uninitialized = new Char(null, '\0');
}
