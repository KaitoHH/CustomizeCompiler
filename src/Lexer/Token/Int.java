package Lexer.Token;

import Lexer.Automata.Automata;
import Lexer.Automata.AutomataConstructor;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/11/28
 * Description:
 * All rights reserved.
 */
public class Int extends Token {
	private static final String regex = "(0|1|2|3|4|5|6|7|8|9)(0|1|2|3|4|5|6|7|8|9)*";
	public final int value;

	public Int(int value) {
		super(Tag.INT);
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

	public static Automata getAutomata() {
		AutomataConstructor automataConstructor = new AutomataConstructor(regex);
		Automata automata = automataConstructor.getAutomata();
		automata.setTagId(Tag.INT);
		return automata;
	}
}
