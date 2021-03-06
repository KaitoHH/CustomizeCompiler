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

	public AutomataEdge(char ch, AutomataNode dest) {
		condition = new HashSet();
		this.condition.add(ch);
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

	public void addCondition(Set<Character> condition) {
		this.condition.addAll(condition);
	}

    @Override
    public String toString() {
        String name = "Dest: " + dest.toString() + ", Condition: ";
        for(Character c : condition)
            name += c;
        return name;
    }
}