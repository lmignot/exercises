import java.io.*;
import java.nio.file.Paths;

/**
 * Exercise 3 for day 16 of PiJ
 * @author lmignot
 */
public class FileCat {

    private static final String CWD = Paths.get("").toAbsolutePath().toString();

    public static void main (String[] args) {
        if (args != null && args.length > 0) {
            // cat(args[0]);
            // change to read list of files from cmd line
            for(String f : args) {
                cat(f);
            }
        }
    }

    private static void cat (String filename) {
        File file = new File(CWD + File.separator + "data" + File.separator + filename);

        String contents = FileUtils.readFile(file);

        if (contents != null) {
            System.out.println(contents);
        } else {
            System.err.println("There was an error reading from the file" + file.getName());
        }
    }
}
