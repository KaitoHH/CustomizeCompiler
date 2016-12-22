package Lexer.Token;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/11/28
 * Description:
 * All rights reserved.
 */
public class Tag {
	public final static int INT = -2, REAL = -1;
	public final static String[] keywords = new String[]{
			"Int",
			"Real",
			"if",
			"else",
			"while",
			"do",
			"for",
			"break",
			"continue",
			"add",
			"minus",
			"times",
			"divide",
			"mod",
			"less_than",
			"greater_than",
			"and",
			"or",
			"not",
			"eq",
			"scope_start",
			"scope_end",
			"assign",
			"bracket_left",
			"bracket_right",
			"delimiter",
			"neq",
			"id"
	};

	/**
	 * ReadOnly
	 */
	public final static Map<String, Integer> KEY;

	static {
		Map<String, Integer> keys = new HashMap<>();
		int cnt = 0;
		for (String word : keywords) {
			keys.put(word, ++cnt);
		}
		KEY = Collections.unmodifiableMap(keys);
	}


}
