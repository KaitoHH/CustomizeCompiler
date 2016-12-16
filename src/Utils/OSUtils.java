package Utils;

/** OSUtils class gives the type of current operator system
 * @author CtheSky
 */
public class OSUtils {
    private static String OS = System.getProperty("os.name").toLowerCase();

    public static boolean isWindows() { return OS.contains("win"); }
    public static boolean isMac() { return OS.contains("mac"); }
    public static boolean isUnix() { return OS.contains("nix"); }
}
