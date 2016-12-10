package Lexer.Automata;

import Lexer.Token.Tag;
import Lexer.Token.Token;
import Lexer.Token.Word;

import java.util.List;
import java.util.Map;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/1
 * Description:
 * All rights reserved.
 */
public class AutomataRunner {

    public static List<Token> run(List<Automata> automataList, String input) {
        //TODO: complete this function
        return null;
    }

    public static Word matchSingleAutomata(Automata automata, String input, int start) {
        if (automata == null || input == null || start >= input.length()) return null;

        AutomataNode currentNode = automata.getInitialNode();
        Map<AutomataNode, AutomataEdge> edges;
        int matchPosition = -1;
        char nextChar;

        for (int currentPosition = start; currentNode != null && currentPosition < input.length(); currentPosition++) {
            nextChar = input.charAt(currentPosition);
            edges = currentNode.getEdgeMap();
            currentNode = null;

            /*for (AutomataEdge edge: edges) {
                if (edge.getCondition().contains(nextChar)) {
                    currentNode = edge.getDest();
                    break;
                }
            }*/

            if (automata.isAccept(currentNode))
                matchPosition = currentPosition + 1;
        }

        if (matchPosition == -1)
            return null;
        else
            return new Word(Tag.ID, input.substring(start, matchPosition));
    }
}
