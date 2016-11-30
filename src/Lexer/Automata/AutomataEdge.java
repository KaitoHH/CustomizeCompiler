package Lexer.Automata;

import java.util.HashSet;
import java.util.Set;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/11/30
 * Description:
 * All rights reserved.
 */
class AutomataEdge {
	private Set<Character> condition = new HashSet();
	private AutomataNode dest;

	public Set<Character> getCondition() {
		return condition;
	}

	public AutomataNode getDest() {
		return dest;
	}

	public void setDest(AutomataNode dest) {
		this.dest = dest;
	}
}