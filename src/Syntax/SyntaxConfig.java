package Syntax;

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
	Map<String, Symbol> tokenMap;
	CFL cfl;

	/**
	 * This function reads a production config file(json) and translate into <b>CFL Class</b>
	 * @see CFL class
	 */
	public SyntaxConfig() {
		JSONObject jsonObject = SyntaxJSONUtils.getCFL();
		Iterator<String> productions = jsonObject.keys();
		tokenMap = new HashMap<>();
		cfl = new CFL();
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
			return new Ntrl(name);
		} else {
			return new Trl(name);
		}
	}

	public CFL getCfl() {
		return cfl;
	}
}
