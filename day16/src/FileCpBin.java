import java.io.File;
import java.nio.file.Paths;

/**
 * Exercise 9 for day 16 of PiJ
 * @author lmignot
 */
public class FileCpBin {

    private static final String CWD = Paths.get("").toAbsolutePath().toString() + File.separator + "data";

    public static void main (String[] args) {
        FileCpBin app = new FileCpBin();

        if (args.length != 2) {
            System.out.println("You need to specify a source and destination name");
        } else {
            if (app.cp(args[0], args[1])) {
                System.out.println("File copied successfully.");
            } else {
                System.err.println("Unable to copy the file.");
            }
        }
    }

    private boolean cp (String src, String dest) {
        boolean result = false;
        File in = new File(CWD + File.separator + src);
        File out = new File(CWD + File.separator + dest);

        if (!in.exists()) {
            System.err.println("File " + in.getName() + " does not exist, please try again.");
        } else {
            boolean proceed = true;
            if (out.exists()) {
                proceed = FileUtils.confirmOverwrite(out);
            }
            if (proceed) {
                result = FileUtils.cpBinary(in, out);
            }
        }
        return result;
    }
}
