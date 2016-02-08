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

        switch (args.length) {
            case 0:
                System.out.println("Please specify a source and destination, or a list of files and destination " +
                        "folder");
                break;
            case 1: {
                System.out.println("Please specify source file(s) and destination filename or folder");
                break;
            }
            case 2: {
                original = args[0];
                destination = args[1];

                if (cp(original, destination)) {
                    System.out.println("Copy successful!");
                }
                break;
            }
            default: {
                String destPath = args[args.length - 1];
                File dest = new File(CWD + File.separator + destPath);
                if(!dest.isDirectory()) {
                    System.out.println("Last argument should be a destination folder.");
                } else {
                    for (int i = 0; i < args.length - 1; i++) {
                        if (cp(args[i], dest.getName() + File.separator + args[i])) {
                            System.out.println("Copied " + args[i] + " to " +
                                    dest.getName() + File.separator + args[i]);
                        } else {
                            System.out.println("Failed to copy " + args[i]);
                        }
                    }
                }
                break;
            }
        }
    }

    public static boolean cp (String original, String destination) {
        File origin = new File(CWD + File.separator + original);
        File dest = new File(CWD + File.separator + destination);
        String confirmation;

        if (!origin.exists()) {
            System.err.println("File " + original + " does not exist, please try again.");
            return false;
        }

        // destination file exists so get an overwrite confirmation
        if (dest.exists()) {
            System.out.print("A file named " + destination + " exists, do you want to overwrite it? (Y/N) ");
            Scanner sc = new Scanner(System.in);
            confirmation = sc.nextLine();
            if (!confirmation.equals("Y") && !confirmation.equals("y")) {
                System.out.println("Exiting... goodbye!");
                return false;
            }
        } else {
            confirmation = "y";
        }

        if (confirmation != null) {
            System.out.println("Copying " + origin.getPath() + " to " + dest.getPath());

            // read in the file contents
            try (BufferedReader in = new BufferedReader(new FileReader(origin))) {
                
                // write the file contents to the destination file
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
