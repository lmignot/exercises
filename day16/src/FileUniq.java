import java.io.File;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * Exercise 7 for day 16 of PiJ
 * @author lmignot
 */
public class FileUniq {
    private static final String CWD = Paths.get("").toAbsolutePath().toString() + File.separator + "data";

    public static void main (String[] args) {
        FileUniq app = new FileUniq();

        switch (args.length) {
            case 0: {
                System.out.println("Please specify a file.");
                break;
            }
            default: {
                File f = new File(CWD + File.separator + args[0]);

                if (!f.exists()) {
                    System.out.println("The file does not exist, please try again.");
                } else {
                    app.printUniq(f);
                }
            }
        }
    }

    private void printUniq (File f) {
        String contents = FileUtils.readFile(f);

        if (contents == null) {
            System.err.println("Nothing to do, the file is empty");
        } else {
            String[] toSort = contents.split("\n");

            // use a Set since it all elements must be unique :)
            Set<String> uniq = new HashSet<>();

            for (String s : toSort) {
                if (!s.equals("")) {
                    uniq.add(s);
                }
            }

            // print out each item in the Set
            uniq.forEach(System.out::println);
        }
    }
}
