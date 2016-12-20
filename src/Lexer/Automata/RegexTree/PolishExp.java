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

	/**
	 * This function reads a regex, and than generate corresponding polish expression
	 * @param expression regex to be parsed
	 * @exception StringIndexOutOfBoundsException this exception will be thrown
	 * if no character is followed by the escaped character '~'
	 */
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
							opStack.push(getCh('+'));
						} else {
							exp.add(opStack.pop());
							opStack.push(getCh('+'));
						}
					}
					opStack.push(getCh(ch));
					isDefault = false;
					break;
				case '|':
					if (opStack.empty() || opStack.peek() == '(') {
						opStack.push(getCh(ch));
					} else {
						exp.add(opStack.pop());
						opStack.push(getCh(ch));
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
					exp.add(getCh(ch));
					isDefault = true;
					break;
				case '~':
				default:
					if (ch == '~') {
						try {
							ch = expression.charAt(++i);
						} catch (StringIndexOutOfBoundsException e) {
							throw new StringIndexOutOfBoundsException("a character must be followed by an escaped character");
						}
					}
					if (isDefault) {
						if (opStack.empty() || opStack.peek() == '(') {
							opStack.push(getCh('+'));
						} else {
							exp.add(opStack.pop());
							opStack.push(getCh('+'));
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
		exp.add(getCh('#'));
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

	public Character getCh(char ch) {
		switch (ch) {
			case '+':
				return RegexTreeGenerator.CAT;
			case '*':
				return RegexTreeGenerator.CLO;
			case '|':
				return RegexTreeGenerator.OR;
			case '#':
				return RegexTreeGenerator.SHARP;
			default:
				return ch;
		}
	}
}
