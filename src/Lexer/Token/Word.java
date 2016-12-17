package Lexer.Token;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/11/28
 * Description:
 * All rights reserved.
 */
public class Word extends Token {
	public final String lexeme;

	public Word(int t, String lexeme) {
		super(t);
		this.lexeme = lexeme;
	}

	@Override
	public int getLength() {
		return lexeme.length();
	}
}
