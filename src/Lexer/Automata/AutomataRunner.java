package Lexer.Automata;

import Lexer.Token.Tag;
import Lexer.Token.Token;
import Lexer.Token.Word;

import java.util.ArrayList;
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
    private static Token longest;

    public static List<Token> run(List<Automata> automataList, String input) {
        //TODO: complete this function
        return null;
    }

    /** Find the longest matched token with automatas using multi-threading
     *
     * @param automatas	    Automatas to match with
     * @param input	        String of input file
     * @param start	        int of start position to match
     * @return			        Longest matched Token
     */
    public static Token matchLongestToken(List<Automata> automatas, String input, int start) {
        List<Thread> threads = new ArrayList<>();
        longest = null;

        for (Automata automata : automatas) {
            Thread thread = new Thread(){
                @Override
                public void run() {
                    Token matched = matchSingleAutomata(automata, input , start);
                    if (matched != null)
                        synchronized ("multi automata match lock") {
                            if (longest == null || matched.getLength() > longest.getLength())
                                longest = matched;
                        }
                }
            };
            threads.add(thread);
            thread.start();
        }

        for (Thread t : threads)
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        return longest;
    }

    /** Find the longest matched token with a single automata
     *
     * @param automata	        Automata to match with
     * @param input	        String of input file
     * @param start	        int of start position to match
     * @return			        Longest matched Token (currently return a Word)
     */
    public static Word matchSingleAutomata(Automata automata, String input, int start) {
        if (automata == null || input == null || start >= input.length()) return null;

        char nextChar;
        int matchPosition = -1;
        AutomataNode currentNode = automata.getInitialNode();

        for (int currentPosition = start; currentNode != null && currentPosition < input.length(); currentPosition++) {
            nextChar = input.charAt(currentPosition);
            currentNode = currentNode.getDest(nextChar);
            if (automata.isAccept(currentNode))
                matchPosition = currentPosition + 1;
        }

        if (matchPosition == -1)
            return null;
        else
            return new Word(Tag.ID, input.substring(start, matchPosition));
    }
}
