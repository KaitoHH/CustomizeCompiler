package Lexer;

import Lexer.Automata.Automata;
import Lexer.Automata.AutomataRunner;
import Lexer.Token.Int;
import Lexer.Token.Real;
import Lexer.Token.Token;
import Preprocessor.Preprocessor;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/11/28
 * Description:
 * All rights reserved.
 */
public class Lexer {
	private Map<String, Token> words;
	private List<Automata> automataList;
	private List<Token> tokenList = null;

	public Lexer(String input) throws IOException {
		words = new HashMap();
		input = Preprocessor.process(input);
		LexerConfig config = new LexerConfig();
		automataList = config.getAutomataList();
		automataList.add(Real.getAutomata());
		automataList.add(Int.getAutomata());
		try {
			tokenList = AutomataRunner.run(automataList, input);
		} catch (IllegalLexemeException e) {
			e.printStackTrace();
		}
	}

	public List<Token> getTokenList() {
		return tokenList;
	}
}
