package Lexer;

import Lexer.Automata.Automata;
import Lexer.Token.Tag;
import Utils.LexerJSONUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/12/20
 * Description:
 * All rights reserved.
 */
public class LexerConfig {
	private List<Automata> automataList;

	public List<Automata> getAutomataList() {
		return automataList;
	}

	/**
	 * This function read lexer config from the file <b>lexer.json</b> and output a list consists of
	 * automata for AutomataRunner to use
	 *
	 * @throws IOException      when processing file
	 * @throws RuntimeException some Runtime exception may be thrown because of wrong regex
	 *                          use getMessage() to get more detailed information
	 */
	public LexerConfig() throws IOException {
		JSONObject jsonObject = LexerJSONUtils.getLanguageDefinition();
		automataList = new ArrayList();
		Map<String, Integer> keys = Tag.KEY;
		Iterator<String> iterator = jsonObject.keys();
		while (iterator.hasNext()) {
			String next = iterator.next();
			if (!keys.containsKey(next)) {
				Tag.addKey(next);
				String regex = jsonObject.getString(next);
				automataList.add(Automata.getAutomataFromRegex(regex, keys.get(next)));
			}
		}

		for (Map.Entry<String, Integer> entry : keys.entrySet()) {
			String regex = jsonObject.getString(entry.getKey());
			automataList.add(Automata.getAutomataFromRegex(regex, entry.getValue()));
		}

		//System.out.println(Tag.getTerminalString());
	}

	public static void main(String[] args) {
		LexerConfig config = null;
		try {
			config = new LexerConfig();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Automata> list = config.getAutomataList();
	}
}
