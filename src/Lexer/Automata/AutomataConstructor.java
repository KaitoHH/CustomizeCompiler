package Lexer.Automata;

import Lexer.Automata.RegexTree.RegexTree;

import java.util.Vector;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/12/10
 * Description:
 * All rights reserved.
 */

public class AutomataConstructor {
	public AutomataConstructor(RegexTree root, Vector<RegexTree> leafNode) {
		Automata automata = new Automata();
		AutomataNode initialNode = new AutomataNode(root.getFirstPos());
		automata.addNode(initialNode);
		automata.setInitialNode(initialNode);

	}
}
