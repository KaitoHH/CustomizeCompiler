package LexerTest.AutomataTest;

import Lexer.Automata.Automata;
import Lexer.Automata.AutomataConstructor;
import Lexer.Automata.AutomataRunner;
import Lexer.Automata.AutomataVisualization;
import Lexer.IllegalLexemeException;
import Lexer.Token.Token;
import Lexer.Token.Word;
import Preprocessor.Preprocessor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;



/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/1
 * Description:
 * All rights reserved.
 */
public class AutomataRunnerTest {

	@Test
	public void matchSingleAutomataTest() {
		AutomataConstructor automataConstructor = new AutomataConstructor("(a|b)*abb");
		Automata automata = automataConstructor.getAutomata();
		System.out.println(AutomataVisualization.getTex(automata));
		// automata结构见编译原理P114 图3-63

        // Start test to match a{0, 10}bb
        StringBuilder sb = new StringBuilder("bb");
        Word word = AutomataRunner.matchSingleAutomata(automata, sb.toString(), 0);
        assertNull(word);
        for (int i = 1; i < 10; i++) {
            sb.insert(0, 'a');
            word = AutomataRunner.matchSingleAutomata(automata, sb.toString(), 0);
            assertNotNull(word);
            assertEquals(sb.toString(), word.lexeme);
        }

	}

    @Test
    public void matchLongestTokenTest() {
        List<Automata> automatas = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++)
            sb.append("b");
        String input = sb.toString();

        sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append("b");
            automatas.add(new AutomataConstructor(sb.toString()).getAutomata());
            Token token = AutomataRunner.matchLongestToken(automatas, input, 0);

            assertEquals(i + 1, token.getLength());
        }
    }

    @Test
    public void runTest() {
        String input = "a b a b\n" +
                "b a\n" +
                "b a";
        Preprocessor.removeComment(input);
        Automata a = new AutomataConstructor("a").getAutomata();
        Automata b = new AutomataConstructor("b").getAutomata();
        List<Automata> automatas = new ArrayList<>();
        automatas.add(a);
        automatas.add(b);

        try{
            List<Token> tokens = AutomataRunner.run(automatas, "abc");
        } catch (IllegalLexemeException e) {
            assertEquals(1,e.lineNum);
            assertEquals(3,e.lineOffset);
        }

        try{
            List<Token> tokens = AutomataRunner.run(automatas, input);
            assertEquals(8, tokens.size());

            Token b2 = tokens.get(3);
            assertEquals("b", b2.toString());
            assertEquals(1, b2.lineNum);
            assertEquals(7, b2.lineOffset);

            Token b3 = tokens.get(4);
            assertEquals("b", b3.toString());
            assertEquals(2, b3.lineNum);
            assertEquals(1, b3.lineOffset);

            Token b4 = tokens.get(6);
            assertEquals("b", b4.toString());
            assertEquals(3, b4.lineNum);
            assertEquals(1, b4.lineOffset);
        } catch (IllegalLexemeException e){
            e.printStackTrace();
        }
    }
}
