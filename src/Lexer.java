import java.util.HashMap;
import java.util.Map;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/11/28
 * Description:
 * All rights reserved.
 */
public class Lexer {
	private Map<String, Token> words;

	public Lexer() {
		words = new HashMap();
		Map<String, Integer> keyMap = Tag.KEY;
		for (Map.Entry<String, Integer> entry : keyMap.entrySet()) {
			words.put(entry.getKey(), new Word(entry.getValue(), entry.getKey()));
		}

	}
}
