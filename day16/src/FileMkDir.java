import java.io.File;
import java.nio.file.Paths;

/**
 * Exercise 2 for day 16 of PiJ
 * @author lmignot
 */
public class FileMkDir {

    private static final String CWD = Paths.get("").toAbsolutePath().toString();

    public static void main (String[] args) {
        if (args.length > 0) {
            System.out.println("Attempting to create dir " + args[0] + "...");
            if (mkdir("data" + File.separator + args[0])) {
                System.out.println("Success!");
            } else {
                System.out.println("Failed!");
            }
        }
    }

    public static boolean mkdir (String dirName) {
        File curDir = new File(CWD + File.separator + "data");
        boolean result = false;

        if (curDir.exists() && curDir.isDirectory()) {
            if(!curDir.canWrite()) {
                result = false;
            } else {
                File newDir = new File(dirName);
                if (!newDir.exists()) {
                    try {
                        result = newDir.mkdir();
                    } catch (SecurityException se) {
                        se.printStackTrace();
                        result = false;
                    }
                } else {
                    result = false;
                }
            }
        }

        return result;
    }

}
