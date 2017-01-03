import Lexer.LexerConfig;
import Lexer.Token.Tag;
import Syntax.CFL.CFL;
import Syntax.SyntaxConfig;
import Utils.FileUtils;
import Utils.OSUtils;

import java.io.IOException;

/**
 * Project: CustomizeCompiler
 * Package: Syntax
 * Create Date: 2016/12/24
 * All rights reserved 2016
 *
 * @author huang
 * @version 1.0
 */
public class GrammarFactory {
	private final static String[] rule = new String[]
			{
					"single_while",
					"assignment",
					"declaration",
					"single_if",
					"if_else",
					"do_while"
			};

	public static void createProduction(CFL cfl) throws IOException {
		String fileString = FileUtils.getFileString("spec/const.cup");
		fileString = fileString.replace("/* Terminals stub#01 */", Tag.getTerminalString());
		for (int i = 0; i < rule.length; i++) {
			fileString = fileString.replace("/*" + rule[i] + "*/", cfl.getProductionList(rule[i]).get(0).toString());
		}
		FileUtils.createFile("production.cup", fileString);
	}

	public static void updateCupFile() throws IOException {
		new LexerConfig();
		SyntaxConfig config = new SyntaxConfig();
		CFL cfl = config.getCfl();
		GrammarFactory.createProduction(cfl);
	}

	public static void compileCUP() {
		String[] cmd1 = new String[]{"java", "-jar", "lib/java-cup-11b.jar",
				"-package", "Syntax",
				"-locations", "production.cup"};
		String[] cmd2, cmd3;
		if (OSUtils.isWindows()) {
			cmd2 = new String[]{"cmd", "/c", "move", "Parser.java", "src/Syntax"};
			cmd3 = new String[]{"cmd", "/c", "move", "ParserSym.java", "src/Syntax"};
		} else {
			cmd2 = new String[]{"mv", "Parser.java", "src/Syntax"};
			cmd3 = new String[]{"mv", "ParserSym.java", "src/Syntax"};
		}
		System.out.println(OSUtils.executeCMD(cmd1));
		OSUtils.executeCMD(cmd2);
		OSUtils.executeCMD(cmd3);
	}

	public static void main(String[] args) throws IOException {
		updateCupFile();
		compileCUP();
	}
}
