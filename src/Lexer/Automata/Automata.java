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
	private Set<AutomataNode> accept = new HashSet();
	private Set<AutomataNode> nodes = new HashSet();
	private AutomataNode initialNode;

	public boolean isAccept(AutomataNode node) {
		return accept.contains(node);
	}

	public Set<AutomataNode> getNodes() {
		return nodes;
	}

	public AutomataNode getInitialNode() {
		return initialNode;
	}

	public void setInitialNode(AutomataNode initialNode) {
		this.initialNode = initialNode;
	}
}
