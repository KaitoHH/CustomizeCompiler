package CodeGenerator;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	public JSONObject toJSON() {
		JSONObject jsonObject = new JSONObject();
		List<Map<String, Integer>> array = new ArrayList<>();
		int lineCnt = 0;
		int covCnt = 0;
		for (Map.Entry<Integer, Integer> entry : line.entrySet()) {
			Map<String, Integer> map = new HashMap<>();
			map.put("line", entry.getKey());
			map.put("call", entry.getValue());
			if (entry.getValue() != 0) {
				covCnt++;
			}
			array.add(map);
			lineCnt++;
		}
		jsonObject.put("line", array);
		jsonObject.put("lines", lineCnt);
		jsonObject.put("coverage", 100.0 * covCnt / lineCnt);
		return jsonObject;
	}
}
