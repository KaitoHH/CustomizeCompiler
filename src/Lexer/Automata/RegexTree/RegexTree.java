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
	public final static byte CAT = -1, STAR = -2, OR = -3;
	private int curNode;
	private int no;
	private RegexTree leftNode;
	private RegexTree rightNode;
	private Set<Integer> firstPos;
	private Set<Integer> lastPos;
	private boolean nullable;

	public RegexTree(RegexTree leftNode, RegexTree rightNode, int curNode) {
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.curNode = curNode;
		firstPos = new HashSet();
		lastPos = new HashSet();
	}

	public RegexTree(int curNode) {
		this(null, null, curNode);
	}

	public RegexTree(RegexTree singleNode, int curNode) {
		this(singleNode, null, curNode);
	}

	public int getCurNode() {
		return curNode;
	}

	public void setNo(int no) {
		this.no = no;
	}
}
