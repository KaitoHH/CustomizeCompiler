package Syntax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	Map<Ntrl, List<Production>> productionMap;

	public CFL() {
		productionMap = new HashMap<>();
	}

	public void addProduction(Production production) {
		Ntrl initial = production.getInitial();
		if (!productionMap.containsKey(initial)) {
			productionMap.put(initial, new ArrayList<>());
		}
		productionMap.get(initial).add(production);
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
