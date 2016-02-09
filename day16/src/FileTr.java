import java.io.File;
import java.nio.file.Paths;

/**
 * Exercise 5 for day 16 of PiJ
 * @author lmignot
 */
public class FileTr {

    private static final String CWD = Paths.get("").toAbsolutePath().toString() + File.separator + "data";

    public static void main (String[] args) {
        FileTr app = new FileTr();

        switch (args.length) {
            case 0:
            case 1:
            case 2: {
                System.out.println("Please specify a file to read, the text to search for and the replacement text");
                break;
            }
            default: {
                File f = new File(CWD + File.separator + args[0]);

                if (!f.exists()) {
                    System.out.println("The file does not exist, please try again.");
                } else {
                    app.tr(f, args[1], args[2]);
                }
            }
        }
    }

    private void tr (File f, String a, String b) {
        String contents = FileUtils.readFile(f);

        if (contents != null) {
            String swapped = contents.replaceAll(a, b);
            System.out.println(swapped);
        }
    }

}
