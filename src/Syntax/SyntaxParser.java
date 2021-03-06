package Syntax;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;

import java.util.List;

/**
 * Project: CustomizeCompiler
 * Package: PACKAGE_NAME
 * Create Date: 2016/12/24
 * All rights reserved 2016
 *
 * @author huang
 * @version 1.0
 */
public class SyntaxParser extends Parser {
	private final static int[] commonMiss = new int[]{
			ParserSym.SCOPE_START, ParserSym.SCOPE_END, ParserSym.DELIMITER, ParserSym.BRACKET_LEFT, ParserSym.BRACKET_RIGHT
	};

	public SyntaxParser(Scanner s, SymbolFactory sf) {
		super(s, sf);
	}

	@Override
	public void syntax_error(Symbol cur_token) {
		ComplexSymbolFactory.ComplexSymbol token = (ComplexSymbolFactory.ComplexSymbol) cur_token;
		try {
			System.err.println("An error occurred at Line " + token.xleft.getLine() +
					" ,Column " + token.xleft.getColumn());
		} catch (NullPointerException e) {
			System.err.println("An error occurred at " + token);
		}
		List<Integer> list = expected_token_ids();
		//report_expected_token_ids();
		for (int id : commonMiss) {
			if (list.contains(id)) {
				System.out.println("Are you probably missing " + ParserSym.terminalNames[id] + "?");
			}
		}
	}
}
