package Preprocessor;

import javafx.util.Pair;
import java.util.*;

/** Preprocessor class does following things:
 *      1. macro replacement
 *      2. remove comment
 *      3. line mapping between processed and original file
 * @author CtheSky
 */
public class Preprocessor {
    private static String source;
    private static StringBuilder sb;
    private static int position;
    private static List<Integer> lineLog;
    private static List<Pair<Integer, Integer>> commentLog;

    /** Process the given input
     *
     * @param source	    String of input file
     * @return			    String of processed file
     */
    public static String process(String source) {
        // TODO: Macro command replace
        source = removeComment(source);

        return source;
    }

    /** Position -> Line/Position Mapping between original and processed file
     *
     * @param pos	        int of position in processed file
     * @return			    Pair of two Integers standing for lineNum and offset
     */
    public static Pair<Integer, Integer> getPositionPair(int pos) {
        int originalPos = getOriginalPosition(pos);
        return getLineOffsetPair(originalPos);
    }

    /** Position -> Position Mapping between original and processed file
     *
     * @param pos	        int of position in processed file
     * @return			    int of position in original file
     */
    public static int getOriginalPosition(int pos) {
        for (int i = 0; i < commentLog.size(); i++) {
            int start = commentLog.get(i).getKey();
            int length = commentLog.get(i).getValue();

            if (pos >= start)
                pos += length;
            else
                break;
        }
        return pos;
    }

    /** Position -> Line/Position Mapping between original position and lineNum/offset
     *
     * @param pos	        int of position in original file
     * @return			    Pair of two Integers standing for lineNum and offset
     */
    public static Pair<Integer, Integer> getLineOffsetPair(int pos) {
        for (int i = 1; i <= lineLog.size(); i++) {
            if ( i == lineLog.size() || pos <= lineLog.get(i))
                return new Pair<>(i, pos - lineLog.get(i - 1));
        }
        return null;
    }

    /** Remove comment in source string and set up line mapping
     *
     * @param str	        String of input file
     * @return			    String of processed file
     */
    public static String removeComment(String str){
        source = str;
        position = 0;
        sb = new StringBuilder();
        lineLog = new ArrayList<>();
        lineLog.add(-1);
        commentLog = new ArrayList<>();

        while(position < source.length())
            removeComment(source.charAt(position++));
        return sb.toString();
    }

    // --------------- removeComment Helper functions ----------------
    // Check current char & Dispatch control to toCommentEnd, toQuoteEnd
    private static void removeComment(char cur) {
        char next;

        if (cur == '\n')
            lineLog.add(position - 1);
        if (cur == '/') {
            next = source.charAt(position++);
            if (next == '*')
                toCommentEnd();
            else if (next == '/') {
                sb.append(cur);
                removeComment(next);
            } else {
                sb.append(cur);
                sb.append(next);
            }
        }
        else if (cur == '\'' || cur == '"')
            toQuoteEnd(cur);
        else
            sb.append(cur);
    }

    // Set position after the end of comment & Omit inner content
    private static void toCommentEnd() {
        int commentPosition = position - 2;
        char cur = source.charAt(position++);
        char next = source.charAt(position++);

        while (cur != '*' || next != '/') {
            if (cur == '\n') {
                lineLog.add(position - 2);
            }

            cur = next;
            next = source.charAt(position++);
        }
        commentLog.add(new Pair<>(commentPosition, position - commentPosition));
    }

    // Set position after the end of quoted string & Append inner content to string builder
    private static void toQuoteEnd(char quote) {
        char cur = source.charAt(position++);

        sb.append(quote);
        while (cur != quote) {
            sb.append(cur);
            if (cur == '\\')
                sb.append(source.charAt(position++));
            cur = source.charAt(position++);
        }
        sb.append(cur);
    }
}
