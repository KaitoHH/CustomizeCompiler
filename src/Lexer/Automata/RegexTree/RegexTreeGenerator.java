package Lexer.Automata.RegexTree;

import Lexer.Automata.Automata;
import Lexer.Automata.AutomataConstructor;

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

	public RegexTree getRoot() {
		return root;
	}

	public Vector<RegexTree> getLeafNode() {
		return leafNode;
	}

	public static void main(String args[]) {
		RegexTreeGenerator generator = new RegexTreeGenerator("(a|b)*abb");
		SetFunctionCalculator calculator = new SetFunctionCalculator(generator.getRoot(), generator.getLeafNode());
		AutomataConstructor automataConstructor = new AutomataConstructor(calculator.getRoot(), calculator.getLeafNode());
		Automata automata = automataConstructor.getAutomata();
	}
}
