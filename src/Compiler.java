import CodeGenerator.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2017/1/9
 * Description:
 * All rights reserved.
 */
public class Compiler {
	public static List<Generator> execList;

	static {
		execList = new ArrayList<>();
		execList.add(new JSONGenerator());
		execList.add(new JavaGenerator());
		execList.add(new CoverageGenerator());
		execList.add(new ExecGenerator());
		execList.add(new REPL());
		execList.add(new HelpGenerator());
	}

	public static void main(String[] args) throws IOException {
		try {
			String filename = null;
			List<Generator> generatorList = new ArrayList<>();
			List<List<String>> argsList = new ArrayList<>();

			for (int i = 0; i < args.length; i++) {
				if (args[i].startsWith("-")) {
					boolean find = false;
					for (Generator generator : execList) {
						if (generator.getOption().equals(args[i])) {
							find = true;
							int cnt = generator.getArgsCnt();
							List<String> _args = new ArrayList<>();
							for (int j = 0; j < cnt; j++) {
								_args.add(args[++i]);
							}
							argsList.add(_args);
							generatorList.add(generator);
						}
					}
					if (!find)
						System.out.println("Unknown option: " + args[i]);
				} else {
					filename = args[i];
				}
			}

			if (generatorList.isEmpty()) {
				generatorList.add(new ASTGenerator());
				argsList.add(new ArrayList<>());
			}

			for (List<String> _args : argsList) {
				_args.add(filename);
			}

			for (int i = 0; i < argsList.size(); i++) {
				generatorList.get(i).execute(argsList.get(i).toArray(new String[argsList.get(i).size()]));
			}
		} catch (Exception e) {
			new HelpGenerator().execute(null);
		}
	}
}
