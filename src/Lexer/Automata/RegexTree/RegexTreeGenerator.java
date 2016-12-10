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

	public RegexTreeGenerator(String regex) {
		// 取得后缀表达式
		PolishExp polishExp = new PolishExp(regex);
		suffixExp = polishExp.getExp();

		// 生成语法树
		generateTree();
	}

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
					break;
				default:
					node = new RegexTree(ch);
					node.setNo(++cnt);
					stack.push(node);
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
