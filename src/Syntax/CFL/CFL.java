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
 *
 * @see Production class
 */
public class CFL {
	public Map<Ntrl, List<Production>> productionMap = new HashMap<>();
	private Ntrl initinialNtrl;
	public Set<Trl> trlSet = new HashSet<>();

	public void addTrl(Trl trl) {
		trlSet.add(trl);
	}

	public void addProduction(Production production) {
		Ntrl initial = production.getInitial();
		if (!productionMap.containsKey(initial)) {
			//TODO: temporary change, may need to be modified
			if (production.getInitial().toString().contains("`")) {
				initinialNtrl = production.getInitial();
			}
			productionMap.put(initial, new ArrayList<>());
		}
		productionMap.get(initial).add(production);
	}

	public Ntrl getInitinialNtrl() {
		return initinialNtrl;
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
