package LexerTest.RegexTreeTest;

import Lexer.Automata.RegexTree.PolishExp;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/12/10
 * Description:
 * 本测试用于测试由正则表达式生成的后缀表达式(波兰表达式)
 * <p>
 * All rights reserved.
 */
public class polishExpTest {

	/**
	 * 一个简化的基本标识符的正则表达式形式
	 *
	 * @author KaitoHH
	 */
	@Test
	public void normalValueExpTest() {
		PolishExp polishExp = new PolishExp("_|a|b|c(_|0|1|a|b|c)*");
		String polish = polishExp.getPolishExp();
		assertEquals(polish, "_a|b|c|_0|1|a|b|c|*+#");
	}

	@Test
	public void simpleRegexTest() {
		PolishExp polishExp = new PolishExp("(a|b)*abb");
		String polish = polishExp.getPolishExp();
		assertEquals(polish, "ab|*a+b+b+#");
	}

	@Test
	public void nestBracketTest() {
		PolishExp polishExp = new PolishExp("a|(b|c*|(d|e)aaa)*");
		String polish = polishExp.getPolishExp();
		assertEquals(polish, "abc*|de||a+a+a+*|#");
	}

	@Test
	public void nestBracketTest2() {
		PolishExp polishExp = new PolishExp("a(b|c*|(d|e)aaa)*");
		String polish = polishExp.getPolishExp();
		assertEquals(polish, "abc*|de||a+a+a+*+#");
	}

	@Test
	public void parallelBracketTest() {
		PolishExp polishExp = new PolishExp("(a|b)*c(d|e*)f*");
		String polish = polishExp.getPolishExp();
		assertEquals(polish, "ab|*c+de*|+f*+#");
	}

	@Test
	public void nestAndBracketTest() {
		PolishExp polishExp = new PolishExp("(a|b)*(c(d|e*))f*");
		String polish = polishExp.getPolishExp();
		assertEquals(polish, "ab|*cde*|++f*+#");
	}

	@Test
	public void noneBracketTest() {
		PolishExp polishExp = new PolishExp("abcdefg");
		String polish = polishExp.getPolishExp();
		assertEquals(polish, "ab+c+d+e+f+g+#");
	}

	@Test
	public void noneBracketTest2() {
		PolishExp polishExp = new PolishExp("ab*c*def*g");
		String polish = polishExp.getPolishExp();
		assertEquals(polish, "ab*+c*+d+e+f*+g+#");
	}

	/**
	 * <b>以下测试可能存在歧义</b>
	 * <p>
	 * 在本实现中，|操作符与连接操作符永远为优先右结合
	 * 因此在解析a|bc|de时 c将首先与左边的表达式结合，然后与|操作符结合。
	 * 另外一种结合的方式是，|操作符首先与两侧的c和d结合。
	 *
	 * @author KaitoHH
	 */
	@Test
	public void noneBracketWithOrOperatorTest() {
		PolishExp polishExp = new PolishExp("a|bc|de");
		String polish = polishExp.getPolishExp();
		assertEquals(polish, "ab|c+d|e+#");

		/* |操作符首先结合的结果如下 */
		//assertEquals(polish,"ab|cd|+e+#");
	}
}
