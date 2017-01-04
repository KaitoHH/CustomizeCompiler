package Lexer.Token;

import javafx.util.Pair;
import org.json.JSONObject;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/11/28
 * Description:
 * All rights reserved.
 */
public abstract class Token {
	public final int tag;
	public int lineNum;
	public int lineOffset;

	public Token(int tag) {
		this.tag = tag;
	}

	public void setPosition(Pair<Integer, Integer> positionPair) {
		lineNum = positionPair.getKey();
		lineOffset = positionPair.getValue();
	}

	public abstract int getLength();
	public abstract String toString();

	public int getLineNum() {
		return lineNum;
	}

	public int getLineOffset() {
		return lineOffset;
	}

	public JSONObject toJSON() {
		JSONObject object = new JSONObject();
		object.put("tag", tag);
		object.put("lineNum", lineNum);
		object.put("lineOffset", lineOffset);
		return object;
	}
}
