package Preprocessor;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/11/29
 * Description:
 * All rights reserved.
 */
public class Preprocessor {
    private static String source;
    private static StringBuilder sb;
    private static int position;

    public static String process(String source) {
        // TODO: Macro command replace
        // TODO: Line number mapping
        source = removeComment(source);

        return source;
    }

    public static String removeComment(String str){
        source = str;
        position = 0;
        sb = new StringBuilder();

        while(position < source.length())
            removeComment(source.charAt(position++));
        return sb.toString();
    }

    // --------------- removeComment Helper functions ----------------
    // Check current char & Dispatch control to
    private static void removeComment(char cur) {
        char next;

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
        char cur = source.charAt(position++);
        char next = source.charAt(position++);

        while (cur != '*' || next != '/') {
            cur = next;
            next = source.charAt(position++);
        }
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
