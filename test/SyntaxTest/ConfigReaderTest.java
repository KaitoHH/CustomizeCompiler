package SyntaxTest;

import Syntax.CFL.CFL;
import Syntax.SyntaxConfig;
import Utils.FileUtils;
import Utils.SyntaxJSONUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/12/22
 * Description:
 * All rights reserved.
 */
public class ConfigReaderTest {
	@Test
	public void sampleTest() {
		SyntaxConfig config = new SyntaxConfig();
		CFL cfl = config.getCfl();
		System.out.println(cfl.toString());
	}

	@Test
	public void productionTest() throws IOException {

		SyntaxConfig config = new SyntaxConfig(SyntaxJSONUtils.getCFLfromJSONstring(FileUtils.getFileString("production.json")));
		CFL cfl = config.getCfl();
		System.out.println(cfl.toString());
	}
}
