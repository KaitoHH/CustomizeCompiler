package Lexer.Token;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/11/28
 * Description:
 * All rights reserved.
 */
public class Num extends Token {
	public final int value;

	public Num(int value) {
		super(Tag.NUM);
		this.value = value;
	}

	@Override
	public int getLength() {
		return toString().length();
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
