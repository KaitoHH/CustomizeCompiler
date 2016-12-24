package LexerTest.AutomataTest;

import Lexer.Automata.Automata;
import Lexer.Automata.AutomataConstructor;
import Lexer.Automata.AutomataVisualization;
import Utils.OSUtils;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Date;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/12/11
 * Description:
 * All rights reserved.
 */
public class AutomataVisualizationTest {
	@Test
	public void simpleTest(){
		demo("abcde");
	}

	@Test
	public void simpleTest2(){
		demo("a|b|c|d|e");
	}

	@Test
	public void simpleTest3(){
		demo("a*b*");
	}

	@Test
	public void normalTest() {
		demo("(a|b)*abb");
	}

	@Test
	public void normalTest2(){
		demo("(a|c)*(d|(a*|b))");
	}

	@Test
	public void complicatedTest(){
		demo("(a|b)*a(a|b)(a|b)(a|b)");
	}

	@Test
	public void complicatedTest2(){
		demo("a|(b|c*|(d|e)aaa)*");
	}

	@Test
	public void complicatedTest3(){
		demo("(a|b)*(c(d|e*))f*");
	}

	/**
	 * put your test here
	 */
	@Test
	public void customTest(){
		//demo("yourTestHere");
		//demo("a*b*(a|b)");
		demo("(0|1|2|3|4|5|6|7|8|9)(0|1|2|3|4|5|6|7|8|9)*");
	}

	public void demo(String regex) {
		AutomataConstructor automataConstructor = new AutomataConstructor(regex);
		Automata automata = automataConstructor.getAutomata();
		String tex = AutomataVisualization.getTex(automata);
		//System.out.println(tex);
		String date = String.valueOf(new Date().getTime());
		String filename = date + ".tex";
		String pdfname = date + ".pdf";
		try {
			AutomataVisualization.texToFile(filename, tex);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String[] cmd1 = new String[]{"pdflatexc", filename};
		String[] cmd2 = new String[]{"/usr/bin/open", "-a", "/Applications/PDF_Expert.app", pdfname};
		String[] cmd3 = new String[]{"rm", date + ".aux", date + ".log", date + ".tex"};
		System.out.println(OSUtils.executeCMD(cmd1));
		System.out.println(OSUtils.executeCMD(cmd2));
		System.out.println(OSUtils.executeCMD(cmd3));
	}
}
