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

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("The file " + filename + " does not exist.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Encountered an error while reading file " + filename);
            ex.printStackTrace();
        }
    }
}
