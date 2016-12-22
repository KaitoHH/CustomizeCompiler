package Syntax.CFL;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/12/22
 * Description:
 * All rights reserved.
 */

/**
 * Production class is a single production in cfl
 * initial :: Ntrl is a nonterminal symbol in the left of the production
 * rule is a Symbol list consists of terminals and nonterminals in the right of the production
 * a production is like:
 * $E -> $E + $T
 * where the symbol begins with '$' is nonterminals , the other terminals
 * @see Symbol base class for terminals and nonterminals
 * @see Ntrl nonterminals extends Symbol
 * @see Trl terminals extenrs Symbol
 */
public class Production {
	private Ntrl initial;
	private List<Symbol> rule;

	public Production(Ntrl ntrl) {
		initial = ntrl;
		rule = new ArrayList<>();
	}

	public void ruleAddSymbol(Symbol symbol) {
		rule.add(symbol);
	}

	public Ntrl getInitial() {
		return initial;
	}

	@Override
	public String toString() {
		String out = initial + "\t->";
		for (Symbol symbol : rule) {
			out += "\t" + symbol;
		}
		out += "\n";
		return out;
	}
}
