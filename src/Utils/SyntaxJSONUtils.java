package Utils;

import org.json.JSONObject;

import java.io.IOException;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/12/22
 * Description:
 * All rights reserved.
 */
public class SyntaxJSONUtils {
	private static JSONObject jsonObject;

	public static JSONObject getCFL() {
		return jsonObject;
	}

	public static JSONObject getCFLfromJSONstring(String jsonString) {
		return new JSONObject(jsonString);
	}

	static {
		try {
			String content = FileUtils.getFileString("production.json");
			jsonObject = new JSONObject(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
