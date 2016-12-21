package Lexer.Token;

import Lexer.Automata.Automata;
import Lexer.Automata.AutomataConstructor;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/12/20
 * Description:
 * All rights reserved.
 */
public class Real extends Token {
	private static final String num = "(0|1|2|3|4|5|6|7|8|9)(0|1|2|3|4|5|6|7|8|9)*";
	private static final String regex = num + "." + "(0|1|2|3|4|5|6|7|8|9)*";
	public final double value;

	public Real(double value) {
		super(Tag.REAL);
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
		automata.setTagId(Tag.REAL);
		return automata;
	}
}
