package Syntax;

import Lexer.Lexer;
import Lexer.Token.Tag;
import Lexer.Token.Token;
import Utils.FileUtils;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Project: CustomizeCompiler
 * Package: PACKAGE_NAME
 * Create Date: 2016/12/24
 * All rights reserved 2016
 *
 * @author huang
 * @version 1.0
 */
public class SyntaxScanner implements Scanner {
	private List<Token> tokenList;
	private Iterator<Token> iterator;
	private ComplexSymbolFactory factory;
	private Map<String, Integer> integerMap;

	public SyntaxScanner(List<Token> list) {
		tokenList = list;
		iterator = list.iterator();
		factory = new ComplexSymbolFactory();
		integerMap = new HashMap<>();
		for (int i = 0; i < ParserSym.terminalNames.length; i++) {
			String name = ParserSym.terminalNames[i];
			integerMap.put(name, i);
		}
	}

	public SymbolFactory getFactory() {
		return factory;
	}

	@Override
	public Symbol next_token() {
		if (iterator.hasNext()) {
			Token token = iterator.next();
			//return factory.newSymbol(token.toString(), integerMap.get(Tag.getKey(token.tag)), token);
			return factory.newSymbol(token.toString(), integerMap.get(Tag.getKey(token.tag)),
			new ComplexSymbolFactory.Location(token.toString(), token.getLineNum(), token.getLineOffset()),
					new ComplexSymbolFactory.Location(token.toString(), token.getLineNum(), token.getLineOffset() + token.getLength())
					, token);
		} else {
			return factory.newSymbol("EOF", ParserSym.EOF,"");
		}
	}

	public static void main(String args[]) throws IOException {
		Lexer lexer = new Lexer(FileUtils.getFileString("source.txt"));
		SyntaxScanner scanner = new SyntaxScanner(lexer.getTokenList());
		Parser p = new SyntaxParser(scanner, scanner.getFactory());
		try {
			Symbol parse = p.parse();
			System.out.println(parse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
