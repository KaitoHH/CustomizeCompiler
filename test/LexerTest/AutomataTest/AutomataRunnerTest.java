package LexerTest.AutomataTest;

import Lexer.Automata.Automata;
import Lexer.Automata.AutomataConstructor;
import Lexer.Automata.AutomataRunner;
import Lexer.Automata.AutomataVisualization;
import Lexer.Token.Token;
import Lexer.Token.Word;
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
}
