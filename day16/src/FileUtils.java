import java.io.File;
import java.nio.file.Paths;

/**
 * Exercises for day 16 of PiJ
 * @author lmignot
 */
public class FileUtils {

    private static final String CWD = Paths.get("").toAbsolutePath().toString()/* + File.separator + "src"*/;

    public static void main (String[] args) {
        ls(CWD + File.separator + "data");
        if (args.length > 0) {
            System.out.println("Attempting to create dir " + args[0] + "...");
            if (mkdir("data" + File.separator + args[0])) {
                System.out.println("Success!");
                ls(CWD + File.separator + "data");
            } else {
                System.out.println("Failed!");
            }
        }
    }

    public static void ls (String dir) {
        File dirToList = new File(dir);
        File[] files;

        if (dirToList.exists() && dirToList.isDirectory()) {
            files = dirToList.listFiles();
            if (files != null) {
                for (File f : files) {
                    System.out.println(f.getName());
                }
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
