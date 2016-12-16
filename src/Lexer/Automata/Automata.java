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
public class Automata {
	private AutomataNode initialNode;
	private Set<AutomataNode> nodeSet;
	private Set<AutomataNode> acceptSet;

	public Automata() {
		initialNode = null;
		nodeSet = new HashSet<>();
		acceptSet = new HashSet<>();
	}

	public Automata(AutomataNode initialNode, Set<AutomataNode> nodeSet, Set<AutomataNode> acceptSet) {
		this.initialNode = initialNode;
		this.nodeSet = nodeSet;
		this.acceptSet = acceptSet;
	}

	public boolean isAccept(AutomataNode node) {
		return acceptSet.contains(node);
	}

	public Set<AutomataNode> getNodes() {
		return nodeSet;
	}

	public AutomataNode getInitialNode() {
		return initialNode;
	}

	public void setInitialNode(AutomataNode initialNode) {
		this.initialNode = initialNode;
	}

	public boolean addNode(AutomataNode node) {
		return nodeSet.add(node);
	}

	public void addAccept(AutomataNode node) {
		acceptSet.add(node);
	}

	public AutomataNode getNode(AutomataNode node) {
		for (AutomataNode curNode : nodeSet) {
			if (node.equals(curNode)) {
				return curNode;
			}
		}
		return null;
	}
}
