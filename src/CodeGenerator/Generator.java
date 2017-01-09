package CodeGenerator;

import java.io.IOException;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2017/1/9
 * Description:
 * All rights reserved.
 */
public interface Generator {
	void execute(String[] args) throws IOException;

	String getOption();

	int getArgsCnt();
}
