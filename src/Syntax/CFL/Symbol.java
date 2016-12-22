package Syntax.CFL;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/12/22
 * Description:
 * All rights reserved.
 */
public abstract class Symbol {
	private String string;

	public Symbol(String s) {
		string = s;
	}

	@Override
	public String toString() {
		return string;
	}
}
