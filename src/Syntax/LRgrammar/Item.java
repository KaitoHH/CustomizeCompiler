package Syntax.LRgrammar;

import Syntax.CFL.Production;
import Syntax.CFL.Symbol;

/**
 * Project: CustomizeCompiler
 * Package: Syntax.LRgrammar
 * Create Date: 2016/12/23
 * All rights reserved 2016
 *
 * @author huang
 * @version 1.0
 */
public class Item {
	private Production production;
	private int pos;

	public Item(Production production, int pos) {
		this.production = production;
		this.pos = pos;
	}

	public Production getProduction() {
		return production;
	}

	public int getPos() {
		return pos;
	}

	public int size() {
		return production.getRule().size();
	}

	public boolean isEnd() {
		return size() == pos;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Item item = (Item) o;

		if (pos != item.pos) return false;
		return production != null ? production.equals(item.production) : item.production == null;
	}

	@Override
	public int hashCode() {
		int result = production != null ? production.hashCode() : 0;
		result = 31 * result + pos;
		return result;
	}

	@Override
	public String toString() {
		String out = production.getInitial() + "\t->";
		int cnt = 0;
		for (Symbol symbol : production.getRule()) {
			if (cnt == pos) {
				out += "\t" + '.';
			}
			cnt++;
			out += "\t" + symbol;
		}
		out += "\n";
		return out;
	}
}
