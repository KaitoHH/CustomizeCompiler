package Lexer.Automata.RegexTree;

import java.util.Vector;

/**
 * Project: CustomizeCompiler
 * Author: huang
 * Create Date: 2016/12/10
 * Description:
 * All rights reserved.
 */

public class SetFunctionCalculator {
	private Vector<RegexTree> leafNode;
	private RegexTree root;

	public SetFunctionCalculator(RegexTree root, Vector<RegexTree> leafNode) {
		this.root = root;
		this.leafNode = leafNode;

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
		calcFollowPos(right);
	}

	public Vector<RegexTree> getLeafNode() {
		return leafNode;
	}

	public RegexTree getRoot() {
		return root;
	}
}
