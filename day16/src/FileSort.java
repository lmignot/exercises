import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Exercise 6 for day 16 of PiJ
 * @author lmignot
 */
public class FileSort {
    private static final String CWD = Paths.get("").toAbsolutePath().toString() + File.separator + "data";

    public static void main (String[] args) {
        FileSort app = new FileSort();

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
                    app.sort(f);
                }
            }
        }
    }

    private void sort (File f) {
        String contents = FileUtils.readFile(f);

        if (contents == null) {
            System.err.println("Nothing to sort, the file is empty");
        } else {
            String[] toSort = contents.split("\n");
            List<String> sorter = new ArrayList<>();

            // strip out the blank lines if there are any
            for (String s : toSort) {
                if (!s.equals("")) {
                    sorter.add(s);
                }
            }
            Collections.sort(sorter);

            sorter.forEach(System.out::println);
        }
    }
}
