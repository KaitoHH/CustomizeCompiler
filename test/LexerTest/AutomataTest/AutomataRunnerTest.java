package LexerTest.AutomataTest;

import Lexer.Automata.Automata;
import Lexer.Automata.AutomataConstructor;
import org.junit.Test;


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
		// automata结构见编译原理P114 图3-63

		/* Construct an automata to match odd occurrences of 'a'
         * Maybe an automata generator would be better
         * initialNode:
         *   0
         * nodeSet:
         *   0  edge:
         *     0 - a -> 1
         *   1  edge:
         *     1 - a -> 0
         * acceptSet:
         *   1
         */
        /*
        Set<Integer> acceptNameSet = new HashSet<>();
        acceptNameSet.add(1);
        AutomataNode accept = new AutomataNode(new HashMap<>(), acceptNameSet);

        Set<Character> condition = new HashSet<>();
        condition.add('a');

        AutomataEdge edgeToAccept = new AutomataEdge(condition, accept);
        Set<AutomataEdge> edgeSetOfInitial = new HashSet<>();
        edgeSetOfInitial.add(edgeToAccept);

        Set<Integer> initialNameSet = new HashSet<>();
        initialNameSet.add(0);
        AutomataNode initial = new AutomataNode(edgeSetOfInitial, initialNameSet);

        AutomataEdge edgeToInitial = new AutomataEdge(condition, initial);
        accept.addEdge(edgeToInitial);

        Set<AutomataNode> nodeSet = new HashSet<>();
        nodeSet.add(accept);
        nodeSet.add(initial);

        Set<AutomataNode> acceptSet = new HashSet<>();
        acceptSet.add(accept);

        Automata matchOddA = new Automata(initial, nodeSet, acceptSet);


        // Start test to match odd number of 'a'
        StringBuilder sb = new StringBuilder();
        Word word = AutomataRunner.matchSingleAutomata(matchOddA, sb.toString(), 0);
        assertNull(word);
        for (int i = 1; i < 10; i++) {
            sb.append('a');
            word = AutomataRunner.matchSingleAutomata(matchOddA, sb.toString(), 0);
            assertEquals(i - (i + 1) % 2, word.lexeme.length());
        }
        */
	}
}
