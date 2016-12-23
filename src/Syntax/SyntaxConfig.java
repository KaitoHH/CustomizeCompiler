package Syntax;

import Syntax.CFL.*;
import Utils.SyntaxJSONUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/12/22
 * Description:
 * All rights reserved.
 */
public class SyntaxConfig {
	Map<String, Symbol> tokenMap = new HashMap<>();
	CFL cfl = new CFL();

	/**
	 * This function reads the default production config file(json) and translate into <b>CFL Class</b>
	 * @see CFL class
	 */
	public SyntaxConfig() {
		JSONObject jsonObject = SyntaxJSONUtils.getCFL();
		generateCFLfromJSON(jsonObject);
	}

	/**
	 * This function receive a jsonObject and translate into <b>CFL Class</b>
	 * @see CFL class
	 */
	public SyntaxConfig(JSONObject jsonObject) {
		generateCFLfromJSON(jsonObject);
	}

	private void generateCFLfromJSON(JSONObject	jsonObject) {
		Iterator<String> productions = jsonObject.keys();
		while (productions.hasNext()) {
			String cur = productions.next();
			Symbol start = getToken(cur);
			JSONArray array = jsonObject.getJSONArray(cur);
			for (int i = 0; i < array.length(); i++) {
				JSONArray rules = array.getJSONArray(i);
				Production production = new Production((Ntrl) start);
				for (int j = 0; j < rules.length(); j++) {
					String rule = rules.getString(j);
					Symbol ruleSymbol = getToken(rule);
					// add terminals into trlSet
					if (ruleSymbol instanceof Trl)
						cfl.trlSet.add((Trl)ruleSymbol);
					production.ruleAddSymbol(ruleSymbol);
				}
				cfl.addProduction(production);
			}
		}
	}

	public Symbol getToken(String name) {
		if (tokenMap.containsKey(name)) {
			return tokenMap.get(name);
		} else {
			Symbol symbol = createSymbol(name);
			tokenMap.put(name, symbol);
			return symbol;
		}
	}

	public Symbol createSymbol(String name) {
		if (name.startsWith("$")) {
			if (name.startsWith("$$")) {
				// start symbol starts with $$
				Ntrl start = new Ntrl(name);
				cfl.startSymbol = start;
				return start;
			}
			return new Ntrl(name);
		} else {
			if (name.equals("epsilon"))
				return Trl.Epsilon;
			else
				return new Trl(name);
		}
	}

	public CFL getCfl() {
		return cfl;
	}
}
