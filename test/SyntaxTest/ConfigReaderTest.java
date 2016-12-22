package SyntaxTest;

import Syntax.CFL.CFL;
import Syntax.SyntaxConfig;
import org.junit.Test;

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
}
