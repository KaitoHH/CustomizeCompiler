package Lexer.Automata.RegexTree;

import java.util.Stack;
import java.util.Vector;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/12/10
 * Description:
 * All rights reserved.
 */
public class RegexTreeGenerator {
	private RegexTree root;
	private Vector<Character> suffixExp;
	private Vector<RegexTree> leafNode;

	public RegexTreeGenerator(String regex) {
		leafNode = new Vector();

		// 取得后缀表达式
		PolishExp polishExp = new PolishExp(regex);
		suffixExp = polishExp.getExp();

		// 生成语法树
		generateTree();

		// nullable
		calcNullable(root);

		// 计算firstpos lastpos
		calcFirstPos(root);
		calcLastPos(root);

		// 计算followpos
		calcFollowPos(root);

	}

	private void calcNullable(RegexTree node) {
		if (node == null) return;
		RegexTree left = node.getLeftNode();
		RegexTree right = node.getRightNode();
		calcNullable(left);
		calcNullable(right);
		if (node.getCurNodeValue() == RegexTree.OR) {
			node.setNullable(left.isNullable() || right.isNullable());
		} else if (node.getCurNodeValue() == RegexTree.CAT) {
			node.setNullable(left.isNullable() && right.isNullable());
		} else if (node.getCurNodeValue() == RegexTree.STAR) {
			node.setNullable(true);
		} else {
			node.setNullable(false);
		}
	}

	private void calcLastPos(RegexTree node) {
		if (node == null) return;
		RegexTree left = node.getLeftNode();
		RegexTree right = node.getRightNode();
		calcLastPos(left);
		calcLastPos(right);
		if (node.getCurNodeValue() == RegexTree.OR) {
			node.addLastPos(left.getLastPos());
			node.addLastPos(right.getLastPos());
		} else if (node.getCurNodeValue() == RegexTree.CAT) {
			if (right.isNullable()) {
				node.addLastPos(left.getLastPos());
				node.addLastPos(right.getLastPos());
			} else {
				node.addLastPos(right.getLastPos());
			}
		} else if (node.getCurNodeValue() == RegexTree.STAR) {
			node.addLastPos(left.getLastPos());
		}
	}

	private void calcFirstPos(RegexTree node) {
		if (node == null) return;
		RegexTree left = node.getLeftNode();
		RegexTree right = node.getRightNode();
		calcFirstPos(left);
		calcFirstPos(right);
		if (node.getCurNodeValue() == RegexTree.OR) {
			node.addFirstPos(left.getFirstPos());
			node.addFirstPos(right.getFirstPos());
		} else if (node.getCurNodeValue() == RegexTree.CAT) {
			if (left.isNullable()) {
				node.addFirstPos(left.getFirstPos());
				node.addFirstPos(right.getFirstPos());
			} else {
				node.addFirstPos(left.getFirstPos());
			}
		} else if (node.getCurNodeValue() == RegexTree.STAR) {
			node.addFirstPos(left.getFirstPos());
		}
	}

	private void calcFollowPos(RegexTree node) {
		if (node == null) return;
		RegexTree left = node.getLeftNode();
		RegexTree right = node.getRightNode();
		if (node.getCurNodeValue() == RegexTree.CAT) {
			for (int pos : right.getFirstPos()) {
				for (int i : left.getLastPos()) {
					leafNode.get(i - 1).addFollowPosIndex(pos);
				}
			}
		} else if (node.getCurNodeValue() == RegexTree.STAR) {
			for (int pos : node.getFirstPos()) {
				for (int i : node.getLastPos()) {
					leafNode.get(i - 1).addFollowPosIndex(pos);
				}
			}
		}
		calcFollowPos(left);
		calcFirstPos(right);
	}

	/**
	 * 生成一棵正则表达式的抽象语法树
	 *
	 * @throws StackOverflowError if regex is wrong
	 */
	public void generateTree() {
		RegexTree left = null, right = null;
		Stack<RegexTree> stack = new Stack();
		int cnt = 0;
		for (char ch : suffixExp) {
			switch (ch) {
				case '+':
					right = stack.pop();
					left = stack.pop();
					stack.push(new RegexTree(left, right, RegexTree.CAT));
					break;
				case '|':
					right = stack.pop();
					left = stack.pop();
					stack.push(new RegexTree(left, right, RegexTree.OR));
					break;
				case '*':
					stack.push(new RegexTree(stack.pop(), RegexTree.STAR));
					break;
				case '#':
					RegexTree node = new RegexTree('#');
					node.setNo(++cnt);
					stack.push(new RegexTree(stack.pop(), node, RegexTree.CAT));
					leafNode.add(node);
					break;
				default:
					node = new RegexTree(ch);
					node.setNo(++cnt);
					stack.push(node);
					leafNode.add(node);
			}
		}
		if (stack.size() != 1) {
			throw new StackOverflowError("stack size != 1");
		}
		root = stack.pop();
	}

	public static void main(String args[]) {
		new RegexTreeGenerator("(a|b)*abb");
	}
}
