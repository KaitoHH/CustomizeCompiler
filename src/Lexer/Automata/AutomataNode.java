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
public class AutomataNode {
	Set<AutomataEdge> edgeSet;
	Set<Integer> nameSet;

	public AutomataNode() {
		edgeSet = new HashSet<>();
		nameSet = new HashSet<>();
	}

	public AutomataNode(Set<AutomataEdge> edgeSet, Set<Integer> name) {
		this.edgeSet = edgeSet;
		this.nameSet = name;
	}

	public AutomataNode(Set<Integer> name) {
		this.nameSet = name;
	}

	public Set<AutomataEdge> getEdgeSet() {
		return edgeSet;
	}

	public boolean addEdge(AutomataEdge edge) {
		return edgeSet.add(edge);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		AutomataNode that = (AutomataNode) o;

		return nameSet.equals(that.nameSet);
	}

	@Override
	public int hashCode() {
		return nameSet.hashCode();
	}
}
