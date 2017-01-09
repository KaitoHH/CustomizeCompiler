package CodeGenerator;

import java.io.IOException;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2017/1/9
 * Description:
 * All rights reserved.
 */
public class HelpGenerator implements Generator {
	@Override
	public void execute(String[] args) throws IOException {
		System.out.println("Usage: compiler [option]\n" +
				"Default:\n" +
				"FILE_NAME                      : compile FILE_NAME to AST\n" +
				"Option:\n" +
				"-exec AST_NAME                 : execute AST_NAME\n" +
				"-json JSON_FILE_NAME AST_NAME  : generate JSON format AST to JSON_FILE_NAME from AST_NAME\n" +
				"-showcoverage SOURCE_NAME      : show SOURCE_NAME code coverage\n" +
				"-tojava JAVA_NAME AST_NAME     : show java code to JAVA_NAME from AST_NAME\n" +
				"-repl                          : running REPL\n" +
				"-help                          : show this\n");
	}

	@Override
	public String getOption() {
		return "-help";
	}

	@Override
	public int getArgsCnt() {
		return 0;
	}
}
