package CodeGenerator;

import Syntax.AST.Statements.Stmt;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/28
 * Description:
 * All rights reserved.
 */
public class JavaGenerator {
    public static String generate(Stmt root) {
        return "public Main class  {\n" +
                "public static void main(String arg[]) {\n" +
                root.toJava("        ") +
                "    }\n" +
                "}";
    }
}
