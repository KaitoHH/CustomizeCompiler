package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
}
