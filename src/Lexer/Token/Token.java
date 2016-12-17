package Lexer.Token;

import Lexer.Lexer;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/11/28
 * Description:
 * All rights reserved.
 */
public abstract class Token {
	public final int tag;
	public Token(int tag) {
		this.tag = tag;
	}
	public abstract int getLength();
}
