package Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * OSUtils class gives the type of current operator system
 *
 * @author CtheSky
 */
public class OSUtils {
	private static String OS = System.getProperty("os.name").toLowerCase();

	public static boolean isWindows() {
		return OS.contains("win");
	}

	public static boolean isMac() {
		return OS.contains("mac");
	}

	public static boolean isUnix() {
		return OS.contains("nix");
	}

	public static String executeCMD(String[] cmd) {
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
}
