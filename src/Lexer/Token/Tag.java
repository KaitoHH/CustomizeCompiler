package Lexer.Token;

import Lexer.Lexer;

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
	public final static Map<String, Integer> KEY;
	private static int keyId = 0;

	static {
		//TODO 初始化KEY
		KEY = new HashMap();

	}

	public static void addKey(String key) {
		KEY.put(key, keyId++);
	}
}
