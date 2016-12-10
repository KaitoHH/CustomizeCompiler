package Lexer.Automata;

import Lexer.Automata.RegexTree.RegexTree;

import java.util.*;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/12/10
 * Description:
 * All rights reserved.
 */

public class AutomataConstructor {
	private Automata automata;

	public AutomataConstructor(RegexTree root, Vector<RegexTree> leafNode) {
		automata = new Automata();
		Queue<AutomataNode> nodes = new LinkedList();

		AutomataNode initialNode = new AutomataNode(root.getFirstPos());
		automata.addNode(initialNode);
		automata.setInitialNode(initialNode);

		nodes.add(initialNode);
		while (!nodes.isEmpty()) {
			AutomataNode curNode = nodes.poll();
			Map<Character, Set<Integer>> map = new HashMap();
			for (int no : curNode.getNameSet()) {
				RegexTree tree = leafNode.get(no - 1);
				char ch = (char) tree.getCurNodeValue();
				if (!map.containsKey(ch)) {
					map.put(ch, new HashSet());
				}
				Set<Integer> set = map.get(ch);
				set.addAll(tree.getFollowPos());
			}

			for (Map.Entry<Character, Set<Integer>> entry : map.entrySet()) {
				if (entry.getValue().size() == 0) continue;
				AutomataNode newNode = new AutomataNode(entry.getValue());
				AutomataEdge edge = new AutomataEdge(entry.getKey(), newNode);
				curNode.addEdge(edge);
				if (automata.addNode(newNode)) {
					nodes.add(newNode);
					if (newNode.getNameSet().contains(leafNode.size())) {
						automata.addAccept(newNode);
					}
				}
				curNode.addEdge(edge);
			}
		}
	}

	public Automata getAutomata() {
		return automata;
	}
}
