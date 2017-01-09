package Utils;

import Syntax.AST.Statements.Stmt;

import java.io.*;

/**
 * Project: CustomizeCompiler
 * Author: KaitoHH
 * Create Date: 2016/12/20
 * Description:
 * All rights reserved.
 */
public class FileUtils {
	public static String getFileString(String filePath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
		StringBuffer bd = new StringBuffer();
		while (true) {
			String str = br.readLine();
			if (str == null) {
				break;
			}
			bd.append(str + "\n");
		}
		br.close();
		return bd.toString();
	}

	public static void createFile(String filename, String content) throws FileNotFoundException {
		FileOutputStream fs = new FileOutputStream(new File(filename));
		PrintStream p = new PrintStream(fs);
		p.println(content);
		p.close();
	}

	public static void serialAST(Stmt root, String filename) throws IOException {
		File file = new File(filename);
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
		oout.writeObject(root);
		oout.close();
	}

	public static Stmt deserialAST(String filename) throws IOException, ClassNotFoundException {
		File file = new File(filename);
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
		Stmt root = (Stmt) oin.readObject();
		oin.close();
		return root;
	}

	public static String replaceExtName(String filename, String ext) {
		String name = filename.substring(0, filename.lastIndexOf('.'));
		return name + "." + ext;
	}
}
