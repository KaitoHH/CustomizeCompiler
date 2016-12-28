package Syntax.AST;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/24
 * Description:
 * All rights reserved.
 */
public class Type {
    public final String name;

    public Type(String name) { this.name = name; }

    public static final Type
            Int  = new Type("Int"),
            Real = new Type("Real"),
            Char = new Type("Char"),
            Bool = new Type("Bool");

    public static boolean numeric(Type t) {
        return t == Int || t == Real;
    }

    public static Type max(Type t1, Type t2) {
        if (numeric(t1) != numeric(t2)) return null;
        else if (!numeric(t1) && !numeric(t2)) return Bool;
        else if (t1 == Real || t2 == Real) return Real;
        else if (t1 == Int || t2 == Int) return Int;
        else return Char;
    }

    public static String toJavaType(Type type) {
        String t;
        if (type == Type.Bool)
            t = "boolean";
        else if (type == Type.Int)
            t = "int";
        else if (type == Type.Real)
            t = "double";
        else
            t = "char";
        return t;
    }
}
