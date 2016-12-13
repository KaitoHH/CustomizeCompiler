package Lexer.Automata;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/11/30
 * Description:
 * All rights reserved.
 */
public class AutomataNode {
	Map<AutomataNode, AutomataEdge> edgeMap;
	Set<Integer> nameSet;

	public AutomataNode() {
		edgeMap = new HashMap<>();
		nameSet = new HashSet<>();
	}

	public AutomataNode(Map<AutomataNode, AutomataEdge> edgeMap, Set<Integer> name) {
		this.edgeMap = edgeMap;
		this.nameSet = name;
	}

	public AutomataNode(Set<Integer> name) {
		this.nameSet = name;
		edgeMap = new HashMap<>();
	}

	public Set<Integer> getNameSet() {
		return nameSet;
	}

	public Map<AutomataNode, AutomataEdge> getEdgeMap() {
		return edgeMap;
	}

	public boolean addEdge(AutomataEdge edge) {
		if (!edgeMap.containsKey(edge.getDest())) {
			edgeMap.put(edge.getDest(), edge);
		} else {
			AutomataEdge curEdge = edgeMap.get(edge.getDest());
			curEdge.addCondition(edge.getCondition());
		}
		return true;
	}

	public AutomataNode getDest(Character c) {
		for (AutomataNode node : edgeMap.keySet()) {
			AutomataEdge edge = edgeMap.get(node);
			if (edge.getCondition().contains(c))
				return node;
		}
		return null;
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

	@Override
	public String toString() {
		String name = "";
		for (Integer i : nameSet)
			name += i;
		return name;
	}
}
