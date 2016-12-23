package Syntax.CFL;

import java.util.*;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/12/22
 * Description:
 * All rights reserved.
 */

/**
 * CFL (Context Free Language) class consists of productions
 * @see Production class
 */
public class CFL {
	public Map<Ntrl, List<Production>> productionMap = new HashMap<>();
	public Set<Trl> trlSet = new HashSet<>();
	public Ntrl startSymbol;

	public void addProduction(Production production) {
		Ntrl initial = production.getInitial();
		if (!productionMap.containsKey(initial)) {
			productionMap.put(initial, new ArrayList<>());
		}
		productionMap.get(initial).add(production);
	}

	/**
	 * Compute first set for all non terminal symbols
	 */
	public void computeAllFollowSets() {
		setEndMarkToStartSymbol();
		int size = -1;
		while (size != getFollowSetTotalSize()) {
			size = getFollowSetTotalSize();
			for (Map.Entry<Ntrl, List<Production>> entry : productionMap.entrySet()) {
				for (Production production : entry.getValue()) {
					computeFollowSet(production);
				}
			}
		}
	}

	private void setEndMarkToStartSymbol(){
		startSymbol.followSet.add(Trl.EndMark);
	}

	private int getFollowSetTotalSize() {
		int size = 0;
		for (Ntrl ntrl : productionMap.keySet()) {
			size += ntrl.followSet.size();
		}
		return size;
	}

	private void computeFollowSet(Production production) {
		Ntrl lhs = production.getInitial();
		List<Symbol> rhs = production.getRule();

		for (int i = 0; i < rhs.size(); i++) {
			Symbol symbol = rhs.get(i);
			if (symbol instanceof Ntrl && i < rhs.size() - 1) {
				for (Trl trl : rhs.get(i + 1).firstSet)
					if (!Trl.isEpsilon(trl))
						symbol.followSet.add(trl);
			}
		}

		for (int i = rhs.size() - 1; i >= 0; i--) {
			Symbol symbol = rhs.get(i);
			if (symbol instanceof Ntrl) {
				symbol.followSet.addAll(lhs.followSet);
			}
			if (!symbol.firstSet.contains(Trl.Epsilon))
				return;
		}
	}

	/**
	 * Compute first set for all symbols
	 */
	public void computeAllFirstSets() {
		setFirstSetOfTrls();
		int size = -1;
		while (size != getFirstSetTotalSize()) {
			size = getFirstSetTotalSize();
			for (Map.Entry<Ntrl, List<Production>> entry : productionMap.entrySet()) {
				for (Production production : entry.getValue()) {
					computeFirstSet(production);
				}
			}
		}
	}

	private void setFirstSetOfTrls() {
		for (Trl trl : trlSet)
			trl.firstSet.add(trl);
	}

	private int getFirstSetTotalSize() {
		int size = 0;
		for (Ntrl ntrl : productionMap.keySet()) {
			size += ntrl.firstSet.size();
		}
		return size;
	}

	private void computeFirstSet(Production production) {
		Ntrl lhs = production.getInitial();
		List<Symbol> rhs = production.getRule();

		if (production.deriveToEpsilonDirectly()) {
			lhs.firstSet.add(Trl.Epsilon);
		} else {
			for (Symbol symbol : rhs) {
				lhs.firstSet.addAll(symbol.firstSet);
				if (!symbol.firstSet.contains(Trl.Epsilon))
					return;
			}
			lhs.firstSet.add(Trl.Epsilon);
		}
	}

	@Override
	public String toString() {
		String output = "";
		for (Map.Entry<Ntrl, List<Production>> entry : productionMap.entrySet()) {
			for (Production production : entry.getValue()) {
				output += production;
			}
		}
		return output;
	}
}
