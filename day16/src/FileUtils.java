import java.io.*;
import java.util.Scanner;

/**
 * Helper class with static methods to support exercises for day 16
 *
 * @author lmignot
 */
public class FileUtils {

    /**
     * Reads the contents of a non-binary file
     * @param f A File object representing the file to read
     * @return The contents of the file if successful, null if not
     */
    public static String readFile (File f) {
        StringBuilder builder = new StringBuilder();
        String result = null;
        try (BufferedReader in = new BufferedReader(new FileReader(f))) {
            String line;
            while((line = in.readLine()) != null) {
                builder.append(line).append("\n");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("The file " + f.getName() + " does not exist.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("Encountered an error while reading file " + f.getName());
            ex.printStackTrace();
        }

        if (builder.toString().length() != 0) {
            result = builder.toString();
        }

        return result;
    }

    /**
     * Write a String to a destination file
     * If the destination exists it will prompt the user to overwrite
     *
     * @param contents The content to write
     * @param f a File object representing the destination file
     * @return True if successful, false if not
     */
    public static boolean writeFile (String contents, File f) {
        try (Writer w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "utf-8"))) {
            w.write(contents);
            return true;
        } catch (FileNotFoundException ex) {
            System.err.println("The file " + f.getName() + " does not exist.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("Encountered an error while writing to file " + f.getName());
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * Copies a binary file to a specified destination
     * If the destination exists it will prompt the user to overwrite
     *
     * @param src a File object representing the file to copy
     * @param dest a File object representing the destination
     * @return true if successful, false if not
     */
    public static boolean cpBinary (File src, File dest) {
        boolean result = false;
        boolean proceed = true;

        if (!src.exists()) {
            System.err.println("The file " + src.getName() + " does not exist.");
            return result;
        }

        if (dest.exists()) {
            proceed = FileUtils.confirmOverwrite(dest);
        }

        if (proceed) {
            try (InputStream in = new BufferedInputStream(new FileInputStream(src));
                 OutputStream out = new BufferedOutputStream(new FileOutputStream(dest))) {

                // store the input bytes in a temporary byte array
                byte[] temp = new byte[(int) src.length()];
                // temporary byte output stream that we copy the temp bytes to
                ByteArrayOutputStream content = new ByteArrayOutputStream(temp.length);

                int bytesRead = 0;

                // bytesRead will be -1 when we've read the whole file
                while (bytesRead != -1) {
                    bytesRead = in.read(temp);
                    // if we've read some bytes put them in the temp output stream
                    if (bytesRead > 0) {
                        content.write(temp, 0, bytesRead);
                    }
                }

                // write the contents to the destination
                out.write(content.toByteArray());
                result = true;

            } catch (FileNotFoundException ex) {
                System.err.println("The file " + src.getName() + " does not exist.");
                ex.printStackTrace();
            } catch (IOException ex) {
                System.err.println("Encountered an error while reading from file " + src.getName());
                ex.printStackTrace();
            }
        }

        return result;
    }

    /**
     * Ask user to confirm whether a file should be overwritten or not
     * @param dest a File object representing the target file
     * @return true if the user confirms with "y", false if not
     */
    public static boolean confirmOverwrite (File dest) {
        boolean result = true;
        System.out.print("A file named " + dest.getName() + " exists, do you want to overwrite it? (y/n) ");
        if (new Scanner(System.in).nextLine().equals("n")) {
            System.err.println("Skipping " + dest.getName());
            result = false;
        }
        return result;
    }
}
