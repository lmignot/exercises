import java.io.*;

/**
 * Helper class with static methods to support exercises for day 16
 *
 * @author lmignot
 */
public class FileUtils {

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

    public static boolean writeFile (String contents, File f) {
        try (Writer w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "utf-8"))) {
            w.write(contents);
            return true;
        } catch (IOException ex) {
            System.err.println("Encountered an error while writing to file " + f.getName());
            ex.printStackTrace();
        }
        return false;
    }
}
