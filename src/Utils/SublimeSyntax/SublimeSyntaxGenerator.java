package Utils.SublimeSyntax;

import Lexer.Token.Tag;
import Utils.FileUtils;
import Utils.LexerJSONUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/22
 * Description:
 * All rights reserved.
 */
public class SublimeSyntaxGenerator {

    /**
     * Read "lexer.json" and generate sublime syntax highlight file
     * To use generated file, put it under plugin directory
     *
     * @throws IOException when missing "syntax_template.txt" or "lexer.json"
     */
    public static void generateSublimeSyntaxFile() throws IOException {
        URL templateUrl = SublimeSyntaxGenerator.class.getResource("/Utils/SublimeSyntax/syntax_template.txt");
        String template = new Scanner(new File(templateUrl.getPath())).useDelimiter("\\Z").next();
        String extensions = "";
        for(String extension : LexerJSONUtils.getLanguageExtentions())
            extensions += "  - ex\n".replace("ex", extension);
        template = template.replace("{{extentions}}", extensions);
        template = template.replace("{{keyword}}", getKeyWordRegular());
        template = template.replace("{{identifier}}", getIdentifierRegular());

        FileUtils.createFile(LexerJSONUtils.getLanguageName() + ".sublime-syntax", template);
    }

    private static List<String> getKeywordRegulars() throws IOException {
        JSONObject jsonObject = LexerJSONUtils.getLanguageDefinition();

        List<String> regulars = new ArrayList<>();
        Map<String, Integer> keys = Tag.KEY;
        for (String keyword : keys.keySet()) {
            if (!keyword.equals("id"))
                regulars.add(jsonObject.getString(keyword));
        }
        return regulars;
    }

    private static String polishRegular(String regular) {
        regular = regular.replace("+", "\\+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < regular.length(); i++) {
            char c = regular.charAt(i);
            if (c == '~') {
                sb.append('\\');
                sb.append(regular.charAt(++i));
            } else {
                sb.append(c);
            }
        }
        return "(" + sb.toString() + ")";
    }

    private static String getKeyWordRegular() throws IOException{
        String keyWordRegular = "";
        List<String> regulars = getKeywordRegulars();
        for (int i = 0 ; i < regulars.size(); i++) {
            keyWordRegular += polishRegular(regulars.get(i));
            if (i != regulars.size() - 1)
                keyWordRegular += "|";
        }
        return keyWordRegular;
    }

    private static String getIdentifierRegular() throws IOException{
        JSONObject jsonObject = LexerJSONUtils.getLanguageDefinition();
        return jsonObject.getString("id");
    }

    public static void main(String[]args){
        try{
            generateSublimeSyntaxFile();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
