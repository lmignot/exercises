import java.io.File;
import java.nio.file.Paths;

/**
 * Exercise 1 for day 16 of PiJ
 * @author lmignot
 */
public class FileLs {

    private static final String CWD = Paths.get("").toAbsolutePath().toString();

    public static void main (String[] args) {
        ls(CWD + File.separator + "data");
    }

    public static void ls (String dir) {
        File dirToList = new File(dir);
        File[] files;

        if (dirToList.exists() && dirToList.isDirectory()) {
            files = dirToList.listFiles();
            if (files != null) {
                for (File f : files) {
                    System.out.println((f.isDirectory() ? "Dir" : "File") + "\t" + f.getName());
                }
            }
        }
    }

}
