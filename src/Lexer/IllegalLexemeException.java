package Lexer;

import javafx.util.Pair;

/** IllegalLexemeException class extends Exception and carry additional info like:
 *      1.lineNum
 *      2.lineOffset
 *  Constructor accepts a pair of two Integer(lineNum, lineOffset)
 * @author CtheSky
 */
public class IllegalLexemeException extends Exception {
    public final int lineNum;
    public final int lineOffset;

    public IllegalLexemeException(Pair<Integer, Integer> positionPair) {
        super("Could not recognize lexeme at line " + positionPair.getKey() + ", offset: " + positionPair.getValue());
        lineNum = positionPair.getKey();
        lineOffset = positionPair.getValue();
    }
}
