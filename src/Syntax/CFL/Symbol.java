package Syntax.CFL;

import java.util.HashSet;
import java.util.Set;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/12/22
 * Description:
 * All rights reserved.
 */
public abstract class Symbol {
	private String string;
	public Set<Trl> firstSet = new HashSet<>();
	public Set<Trl> followSet = new HashSet<>();

	public Symbol(String s) {
		string = s;
	}

	@Override
	public String toString() {
		return string;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
