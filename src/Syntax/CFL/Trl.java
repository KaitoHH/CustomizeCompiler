package Syntax.CFL;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/12/22
 * Description:
 * All rights reserved.
 */
public class Trl extends Symbol {
	public Trl(String s) {
		super(s);
	}

	public static Trl Epsilon = new Trl("epsilon");
	public static Trl EndMark = new Trl("$");

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public static boolean isEpsilon(Symbol symbol) {
		return Epsilon.equals(symbol);
	}
}
