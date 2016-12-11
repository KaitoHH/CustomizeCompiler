package Lexer.Automata;

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
	public static String beginTex() {
		return "\\documentclass{article}\n" +
				"\\usepackage{tikz}\n" +
				"\\usetikzlibrary{automata, positioning}\n" +
				"\\begin{document}\n" +
				"\\begin{tikzpicture} [shorten >=1pt, node distance=2cm, on grid, auto] \n";
	}

	public static String endTex() {
		return "\\end{tikzpicture}\n" +
				"\\end{document}  \n";
	}

	public static String getTex(Automata automata) {
		String tex = beginTex();
		int cnt = 0;
		Map<AutomataNode, Integer> map = new HashMap<>();
		for (AutomataNode node : automata.getNodes()) {
			map.put(node, cnt);
			if (automata.getInitialNode().equals(node)) {
				tex += initialNode(cnt, node.getNameSet().toString());
			} else {
				tex += normalNode(cnt, node.getNameSet().toString());
			}
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

		tex += endTex();
		return tex;
	}

	public static String initialNode(int no, String name) {
		return "\\node[state, initial] (" + no + ")   {$" + name + "$}; \n";
	}

	public static String normalNode(int no, String name) {
		return "\\node[state] (" + no + ") [right of = " + (no - 1) + "] {$" + name + "$};\n";
	}

	public static String addPath(int from, int to, String condition) {
		return "\tedge" + (from == to ? " [loop] " : " ") + "node {" + condition + "} (" + to + ")\n";
	}
}
