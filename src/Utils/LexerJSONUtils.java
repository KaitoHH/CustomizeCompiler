package Utils;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/22
 * Description:
 * All rights reserved.
 */
public class LexerJSONUtils {
    private static JSONObject jsonObject;

    public static String getLanguageName() {
        return jsonObject.getJSONObject("language_info").getString("name");
    }

    public static List<String> getLanguageExtentions() {
        List<String> extensions = new ArrayList<>();
        for (Object object: jsonObject.getJSONObject("language_info").getJSONArray("file_extensions").toList())
            extensions.add(object.toString());
        return extensions;
    }

    public static JSONObject getLanguageDefinition() {
        return jsonObject.getJSONObject("language_definition");
    }

    static {
        try {
            String content = FileUtils.getFileString("lexer.json");
            jsonObject = new JSONObject(content);
        } catch (IOException e) {
            System.out.println("Missing file : lexer.json");
            e.printStackTrace();
        }
    }
}
