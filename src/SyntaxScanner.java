import Lexer.Lexer;
import Lexer.Token.Tag;
import Lexer.Token.Token;
import Utils.FileUtils;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;

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
		for (int i = 0; i < sym.terminalNames.length; i++) {
			String name = sym.terminalNames[i];
			integerMap.put(name, i);
		}
	}

	public ComplexSymbolFactory getFactory() {
		return factory;
	}

	@Override
	public Symbol next_token() {
		if (iterator.hasNext()) {
			Token token = iterator.next();
			return factory.newSymbol(token.toString(), integerMap.get(Tag.getKey(token.tag)));
		} else {
			return factory.newSymbol("EOF", sym.EOF);
		}
	}

	public static void main(String args[]) throws IOException {
		Lexer lexer = new Lexer(FileUtils.getFileString("source.txt"));
		SyntaxScanner scanner = new SyntaxScanner(lexer.getTokenList());
		parser p = new parser(scanner, scanner.getFactory());
		try {
			p.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
