package Syntax.AST;

import java.io.Serializable;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/24
 * Description:
 * All rights reserved.
 */
public class Type implements Serializable{
	public final String name;

	private Type(String name) {
		this.name = name;
	}

	public static final Type
			Int = new Type("Int"),
			Real = new Type("Real"),
			Char = new Type("Char"),
			Bool = new Type("Bool");

	public static boolean numeric(Type t) {
		return t.equals(Int) || t.equals(Real) || t.equals(Char);
	}

	public static Type max(Type t1, Type t2) {
		if (numeric(t1) != numeric(t2)) return null;
		else if (!numeric(t1) && !numeric(t2)) return Bool;
		else if (t1.equals(Real) || t2.equals(Real)) return Real;
		else if (t1.equals(t2)) return t1;
		else return Int;
	}

	public static boolean assignable(Type t1, Type t2) {
		Type maxType = max(t1, t2);
		if (maxType == null)
			return false;
		else if (t1.equals(Real))
			return true;
		else if (t1.equals(Int) && !t2.equals(Real))
			return true;
		else if (t1.equals(Char) && t2.equals(Char))
			return true;
		else
			return false;
	}

	public static String toJavaType(Type type) {
		String t;
		if (type.equals(Type.Bool))
			t = "boolean";
		else if (type.equals(Type.Int))
			t = "int";
		else if (type.equals(Type.Real))
			t = "double";
		else
			t = "char";
		return t;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Type)) return false;

		Type type = (Type) o;

		return name.equals(type.name);
	}
}
