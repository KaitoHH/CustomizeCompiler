package LexerTest;

import Lexer.Lexer;
import Lexer.Token.Token;
import Utils.FileUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/12/21
 * Description:
 * All rights reserved.
 */
public class LexerTest {
	@Test
	public void initialize() throws IOException {
		Lexer lexer = new Lexer(FileUtils.getFileString("source.txt"));
		List<Token> list = lexer.getTokenList();
		for (Token token : list) {
			System.out.println(token);
		}
	}
}
