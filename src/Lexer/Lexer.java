package Lexer;

import Lexer.Token.Tag;
import Lexer.Token.Token;
import Lexer.Token.Word;

import java.util.HashMap;
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

	public Lexer() {
		words = new HashMap();
	}
}
