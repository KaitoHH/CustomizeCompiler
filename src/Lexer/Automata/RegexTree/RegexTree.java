package Lexer.Automata.RegexTree;

import java.util.HashSet;
import java.util.Set;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/12/10
 * Description:
 * All rights reserved.
 */
public class RegexTree {
	private final int CAT = -1, STAR = -2, OR = -3;
	private char curNode;
	private RegexTree leftNode;
	private RegexTree rightNode;
	private Set<Integer> firstPos;
	private Set<Integer> lastPos;
	private boolean nullable;

	public RegexTree(RegexTree leftNode, RegexTree rightNode, char curNode) {
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.curNode = curNode;
		firstPos = new HashSet();
		lastPos = new HashSet();
	}

	public RegexTree(char curNode) {
		new RegexTree(null, null, curNode);
	}

	public RegexTree(RegexTree singleNode, char curNode) {
		new RegexTree(singleNode, null, curNode);
	}

	public char getCurNode() {
		return curNode;
	}
}
