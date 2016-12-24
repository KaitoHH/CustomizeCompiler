package Lexer.Token;

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
	private static int cnt;

	public final static Map<String, Integer> KEY;
	private final static Map<Integer, String> stringMap;

	static {
		KEY = new HashMap<>();
		stringMap = new HashMap<>();
		cnt = 0;
		for (String word : keywords) {
			addKey(word);
		}
	}

	public static String getKey(int id) {
		if (id < 0) {
			return id == -2 ? "INTNUM" : "REALNUM";
		}
		return stringMap.get(id);
	}

	public static void addKey(String word) {
		word = word.toUpperCase();
		KEY.put(word, ++cnt);
		stringMap.put(cnt, word);
	}

	public static String getTerminalString() {
		StringBuffer buffer = new StringBuffer("terminal ");
		boolean first = true;
		for (Map.Entry<String, Integer> entry : KEY.entrySet()) {
			if (first) {
				first = false;
				buffer.append(entry.getKey());
			} else {
				buffer.append("," + entry.getKey());
			}
		}
		buffer.append(";");
		return buffer.toString();
	}
}
