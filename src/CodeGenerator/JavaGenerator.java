package CodeGenerator;

import Syntax.AST.Statements.Stmt;

import java.util.regex.Pattern;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/28
 * Description:
 * All rights reserved.
 */
public class JavaGenerator {
    public static String generate(Stmt root) {
        return "public class Main  {\n" +
                "    public static void main(String arg[]){ \n" +
                addIndent(root.toJava()) +
                "    }\n}";
    }

    public static String addIndent(String input) {
        String indentedCode = "";
        String[] lines = input.split("\n");
        int indent = 8;
        String scopeStart = "\\s*\\{\\s*$";
        String scopeEnd = "\\s*\\}\\s*$";

        for (String line : lines) {
            if (Pattern.matches(scopeEnd, line))
                indent -= 4;

            indentedCode += getIndent(indent) + line + "\n";

            if (Pattern.matches(scopeStart, line))
                indent += 4;

        }
        return indentedCode;
    }

    public static String getIndent(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++)
            sb.append(' ');
        return sb.toString();
    }
}
