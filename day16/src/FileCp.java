import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Exercise 4 for day 16 of PiJ
 * @author lmignot
 */
public class FileCp {

    private static final String CWD = Paths.get("").toAbsolutePath().toString() + File.separator + "data";

    public static void main (String[] args) {
        String original;
        String destination;

        if (args.length == 0) {
            System.out.println("Please specify a source and destination");
        } else if (args.length == 1) {
            System.out.println("Please provide the name for the copy");
        } else if (args.length == 2) {
            original = args[0];
            destination = args[1];

            if (cp(original, destination)) {
                System.out.println("Copy successful!");
            }
        }
    }

    public static boolean cp (String original, String destination) {
        File origin = new File(CWD + File.separator + original);
        File dest = new File(CWD + File.separator + destination);
        String confirmation = null;

        if (!origin.exists()) {
            System.out.println("File " + original + " does not exist, please try again.");
            return false;
        }
        if (dest.exists()) {
            System.out.print("A file named " + destination + " exists, do you want to overwrite it? (Y/N)");
            Scanner sc = new Scanner(System.in);
            confirmation = sc.nextLine();
            if (!confirmation.equals("Y") && !confirmation.equals("y")) {
                System.out.println("Exiting... goodbye!");
                return false;
            }
        }

        if (confirmation != null) {
            try (BufferedReader in = new BufferedReader(new FileReader(origin))) {
                try (Writer writer = new BufferedWriter(
                    new OutputStreamWriter(
                        new FileOutputStream(dest), "utf-8"
                    )
                )) {
                    String line;
                    while((line = in.readLine()) != null) {
                        writer.write(line + "\n");
                    }
                    return true;
                } catch (IOException ex) {
                    System.err.println("Encountered an error while writing to file " + destination);
                    ex.printStackTrace();
                }
        } catch (FileNotFoundException ex) {
                System.err.println("The file " + original + " does not exist.");
                ex.printStackTrace();
            } catch (IOException ex) {
                System.err.println("Encountered an error while reading file " + original);
                ex.printStackTrace();
            }
        }
        return false;
    }
}
