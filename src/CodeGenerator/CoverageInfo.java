package CodeGenerator;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: CustomizeCompiler
 * Package: CodeGenerator
 * Create Date: 2017/1/7
 * All rights reserved 2017
 *
 * @author huang
 * @version 1.0
 */
public class CoverageInfo {
	Map<Integer, Integer> line;

	public CoverageInfo() {
		line = new HashMap<>();
	}

	public void addOrSet(Integer key) {
		Integer call = line.putIfAbsent(key, 1);
		if (call != null) {
			line.put(key, call + 1);
		}
	}

	public void set(Integer key, Integer value) {
		line.put(key, value);
	}

	public Map<Integer, Integer> getLine() {
		return line;
	}
}
