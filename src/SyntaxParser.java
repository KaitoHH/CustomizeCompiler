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
public class SyntaxParser extends parser {
	private final static int[] commanMiss = new int[]{
			sym.SCOPE_START, sym.SCOPE_END, sym.DELIMITER, sym.BRACKET_LEFT, sym.BRACKET_RIGHT
	};

	public SyntaxParser(Scanner s, SymbolFactory sf) {
		super(s, sf);
	}

	@Override
	public void syntax_error(Symbol cur_token) {
		ComplexSymbolFactory.ComplexSymbol token = (ComplexSymbolFactory.ComplexSymbol) cur_token;
		System.err.println("An error occurred at Line " + token.xleft.getLine() +
				" ,Column " + token.xleft.getColumn());
		List<Integer> list = expected_token_ids();
		report_expected_token_ids();
		for (int id : commanMiss) {
			if (list.contains(id)) {
				System.err.println("Are you probably missing " + sym.terminalNames[id] + "?");
			}
		}
	}
}
