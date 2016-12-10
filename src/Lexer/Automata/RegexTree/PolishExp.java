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

public class PolishExp {
	private Vector<Character> exp;

	public PolishExp(String expression) {
		Stack<Character> opStack = new Stack();
		exp = new Vector();
		boolean isDefault = false;
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			switch (ch) {
				case '(':
					if (isDefault) {
						if (opStack.empty() || opStack.peek() == '(') {
							opStack.push('+');
						} else {
							exp.add(opStack.pop());
							opStack.push('+');
						}
					}
					opStack.push(ch);
					isDefault = false;
					break;
				case '|':
					if (opStack.empty() || opStack.peek() == '(') {
						opStack.push(ch);
					} else {
						exp.add(opStack.pop());
						opStack.push(ch);
					}
					isDefault = false;
					break;
				case ')':
					char ch1 = opStack.pop();
					if (ch1 != '(') {
						exp.add(ch1);
						opStack.pop();
					}
					isDefault = true;
					break;
				case '*':
					exp.add(ch);
					isDefault = true;
					break;
				default:
					if (isDefault) {
						if (opStack.empty() || opStack.peek() == '(') {
							opStack.push('+');
						} else {
							exp.add(opStack.pop());
							opStack.push('+');
						}
					}
					isDefault = true;
					exp.add(ch);
					break;
			}
		}
		while (!opStack.empty()) {
			exp.add(opStack.pop());
		}
		exp.add('#');
	}

	public Vector<Character> getExp() {
		return exp;
	}

	public String getPolishExp() {
		String string = new String();
		for (char ch : exp) {
			string += ch;
		}
		return string;
	}
}
