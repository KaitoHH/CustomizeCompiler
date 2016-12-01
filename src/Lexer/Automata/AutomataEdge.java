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
public class AutomataEdge {
	private Set<Character> condition;
	private AutomataNode dest;

	public AutomataEdge() {
		condition = new HashSet<>();
		dest = null;
	}

	public AutomataEdge(Set<Character> condition, AutomataNode dest) {
		this.condition = condition;
		this.dest = dest;
	}


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