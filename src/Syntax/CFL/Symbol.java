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

	public boolean isTrl() {
		return this instanceof Trl;
	}

	public boolean isNtrl() {
		return this instanceof Ntrl;
	}


}
