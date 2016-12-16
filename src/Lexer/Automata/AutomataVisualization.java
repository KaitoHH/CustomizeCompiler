package Lexer.Automata;

import Utils.OSUtils;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Project: CustomizeCompiler
 * Package: Lexer.Automata
 * Create Date: 2016/12/11
 * All rights reserved 2016
 *
 * @author huang
 * @version 1.0
 */
public class AutomataVisualization {

	private static String beginTex() {
		return "\\documentclass[a1paper]{article}\n" +
				"\\usepackage{tikz}\n" +
				"\\usepackage{geometry}\n" +
				"\\geometry{left=1.0cm}\n" +
				"\\usetikzlibrary{automata, positioning}\n" +
				"\\begin{document}\n" +
				"\\begin{tikzpicture} [shorten >=1pt, node distance=2cm, on grid, auto] \n";
	}

	private static String endTex() {
		return "\\end{tikzpicture}\n" +
				"\\end{document}  \n";
	}

	public static String getTex(Automata automata) {
		String tex = beginTex();
		int cnt = 0;
		Map<AutomataNode, Integer> map = new HashMap<>();
		for (AutomataNode node : automata.getNodes()) {
			map.put(node, cnt);
			String state = "state";
			if (automata.getInitialNode().equals(node)) {
				state += ",initial";
			}
			if (automata.isAccept(node)) {
				state += ",accepting";
			}
			tex += addNode(cnt, node.getNameSet().toString(), state);
			cnt++;
		}
		tex += "\\path[->] \n";
		cnt = 0;
		for (AutomataNode node : automata.getNodes()) {
			Map<AutomataNode, AutomataEdge> edgeMap = node.getEdgeMap();
			if (edgeMap.size() != 0) {
				tex += "(" + cnt + ")\n";
			}
			for (Map.Entry<AutomataNode, AutomataEdge> entry : edgeMap.entrySet()) {
				tex += addPath(cnt, map.get(entry.getKey()), entry.getValue().getCondition().toString());
			}
			cnt++;
		}
		tex += ";";
		tex += endTex();
		return tex;
	}

	private static String addNode(int no, String name, String state) {
		if (no == 0) {
			return "\\node[" + state + "] (" + no + ")   {$" + no + "$}; \n";
		}
		return "\\node[" + state + "] (" + no + ") [right of = " + (no - 1) + "]  {$" + no + "$}; \n";
	}


	private static String addPath(int from, int to, String condition) {
		return "\tedge" + (from == to ? " [loop] " : " [bend left=75, min distance = " + (-50 + Math.abs(from - to) * 50) + "] ") + "node {$" + condition + "$} (" + to + ")\n";
	}

	public static void texToFile(String filename, String tex) throws FileNotFoundException {
		FileOutputStream fs = new FileOutputStream(new File(filename));
		PrintStream p = new PrintStream(fs);
		p.println(tex);
		p.close();
	}

	public static String getCmdResult(String[] cmd) {
		StringBuffer sb = null;
		try {
			Process ps = Runtime.getRuntime().exec(cmd);
			BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
			sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * Code below works depending on OS： (require pdflatex installed and added into system path)
	 *     <b>Mac OS</b> with PDF Expert installed (renamed to PDF_Expert)
	 *     <b>Windows OS</b> (call default web browser to open pdf)
	 * change cmd2[] to open other pdf application
	 * @param args ignored
	 * @throws FileNotFoundException ignored
	 * @author KaitoHH
	 */
	public static void main(String[] args) throws FileNotFoundException {
		AutomataConstructor automataConstructor = new AutomataConstructor("(a|b)*abb");
		Automata automata = automataConstructor.getAutomata();
		String tex = AutomataVisualization.getTex(automata);
		String date = String.valueOf(new Date().getTime());
		String filename = date + ".tex";
		String pdfname = date + ".pdf";
		texToFile(filename, tex);
		String[] cmd1, cmd2, cmd3;
		if (OSUtils.isMac()) {
			cmd1 = new String[]{"pdflatexc", filename};
			cmd2 = new String[]{"/usr/bin/open", "-a", "/Applications/PDF_Expert.app", pdfname};
			cmd3 = new String[]{"rm", date + ".aux", date + ".log", date + ".tex"};
		} else if (OSUtils.isWindows()) {
			cmd1 = new String[]{"pdflatex", filename};
			cmd2 = new String[]{"cmd", "/c", "start", pdfname};
			cmd3 = new String[]{"cmd", "/c", "del", date + ".aux", date + ".log", date + ".tex"};
		} else {
			// other os
			cmd1 = null;
			cmd2 = null;
			cmd3 = null;
		}

		System.out.println(getCmdResult(cmd1));
		System.out.println(getCmdResult(cmd2));
		System.out.println(getCmdResult(cmd3));

	}
}
