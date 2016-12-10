package Lexer.Automata.RegexTree;

import java.util.Vector;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/12/10
 * Description:
 * All rights reserved.
 */
public class RegexTreeGenerator {
	private RegexTree root;
	private Vector<Character> suffixExp;

	public RegexTreeGenerator(String regex) {
		PolishExp polishExp = new PolishExp(regex);
		suffixExp = polishExp.getExp();
	}


}
