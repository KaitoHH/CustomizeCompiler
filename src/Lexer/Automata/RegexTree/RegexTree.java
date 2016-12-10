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
	private int curNodeValue;
	private int no;
	private RegexTree leftNode;
	private RegexTree rightNode;
	private Set<Integer> firstPos;
	private Set<Integer> lastPos;
	private Set<Integer> followPos;
	private boolean nullable;

	public RegexTree(RegexTree leftNode, RegexTree rightNode, int curNodeValue) {
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.curNodeValue = curNodeValue;
		firstPos = new HashSet();
		lastPos = new HashSet();
		followPos = new HashSet();
	}

	public RegexTree(int curNodeValue) {
		this(null, null, curNodeValue);
	}

	public RegexTree(RegexTree singleNode, int curNodeValue) {
		this(singleNode, null, curNodeValue);
	}

	public int getCurNodeValue() {
		return curNodeValue;
	}

	public void setNo(int no) {
		this.no = no;
		firstPos.add(no);
		lastPos.add(no);
	}

	public int getNo() {
		return no;
	}

	public RegexTree getLeftNode() {
		return leftNode;
	}

	public RegexTree getRightNode() {
		return rightNode;
	}

	public void addFirstPos(Set<Integer> set) {
		firstPos.addAll(set);
	}

	public void addLastPos(Set<Integer> set) {
		lastPos.addAll(set);
	}

	public void addFollowPosIndex(int index) {
		followPos.add(index);
	}

	public Set<Integer> getFirstPos() {
		return firstPos;
	}

	public Set<Integer> getLastPos() {
		return lastPos;
	}

	public Set<Integer> getFollowPos() {
		return followPos;
	}

	public boolean isNullable() {
		return nullable;
	}

	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}
}
