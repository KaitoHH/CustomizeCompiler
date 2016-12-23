package Syntax.LRgrammar;

import java.util.HashSet;
import java.util.Set;

/**
 * Project: CustomizeCompiler
 * Package: Syntax.LRgrammar
 * Create Date: 2016/12/23
 * All rights reserved 2016
 *
 * @author huang
 * @version 1.0
 */
public class ItemSet {
	Set<Item> set;

	public ItemSet() {
		set = new HashSet<>();
	}

	public Set<Item> getSet() {
		return set;
	}

	@Override
	public String toString() {
		String out = "";
		for (Item item : set) {
			out += item;
		}
		return out;
	}
}
