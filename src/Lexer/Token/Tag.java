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
	public final static int INT = -2, REAL = -1;        //ID指代 标识符

	/**
	 * ReadOnly
	 */
	public final static Map<String, Integer> KEY;
	private static int keyId = 0;

	static {
		Map<String, Integer> keys = new HashMap<>();
		keys.put("add", 1);
		keys.put("minus", 2);
		keys.put("times", 3);
		keys.put("divide", 4);
		keys.put("mod", 5);
		keys.put("less_than", 6);
		keys.put("greater_than", 7);
		keys.put("less_equal", 8);
		keys.put("greater_equal", 9);
		keys.put("neq", 10);
		keys.put("id", 11);
		KEY = Collections.unmodifiableMap(keys);
	}

	public static void addKey(String key) {
		KEY.put(key, keyId++);
	}
}
