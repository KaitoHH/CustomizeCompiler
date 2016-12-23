package Syntax.LRgrammar;

import Syntax.CFL.CFL;
import Syntax.CFL.Production;
import Syntax.SyntaxConfig;

import java.util.*;

/**
 * Project: CustomizeCompiler
 * Package: Syntax.LRgrammar
 * Create Date: 2016/12/23
 * All rights reserved 2016
 *
 * @author huang
 * @version 1.0
 */
public class ItemSetCollection {
	CFL cfl;
	Set<ItemSet> collection;

	public ItemSetCollection(CFL cfl) {
		collection = new HashSet<>();
		this.cfl = cfl;
	}

	public void closure(ItemSet set) {
		Queue<Item> queue = new ArrayDeque<>();
		Set<Item> itemSet = set.getSet();
		for (Item item : itemSet) {
			queue.add(item);
		}
		while (!queue.isEmpty()) {
			Item item = queue.poll();
			int pos = item.getPos();
			if (!item.isEnd() && item.getProduction().isNtrl(pos)) {
				List<Production> list = cfl.productionMap.get(item.getProduction().getSymbol(pos));
				for (Production production : list) {
					Item item1 = new Item(production, 0);
					if (itemSet.add(item1))
						queue.add(item1);
				}
			}
		}
	}

	public static void main(String[] args) {
		SyntaxConfig config = new SyntaxConfig();
		CFL cfl = config.getCfl();
		ItemSetCollection itemSetCollection = new ItemSetCollection(cfl);
		Production production = cfl.productionMap.get(cfl.getInitinialNtrl()).get(0);
		ItemSet set = new ItemSet();
		set.getSet().add(new Item(production, 0));
		itemSetCollection.closure(set);
		for (Item item : set.getSet()) {
			if (item.getProduction().toString().contains("+")) {
				production = item.getProduction();
			}
		}
		System.out.println(production);
		set.getSet().clear();
		set.getSet().add(new Item(production,2));
		itemSetCollection.closure(set);
		System.out.println(set);
	}
}
