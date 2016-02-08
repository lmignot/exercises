import java.io.*;
import java.nio.file.Paths;

/**
 * Exercise 8 for day 16 of PiJ
 * @author lmignot
 */
public class TempAverage {

    private static final String CWD = Paths.get("").toAbsolutePath().toString() + File.separator + "data";

    public static void main (String[] args) {
        File temps = new File(CWD + File.separator + "temps.txt");

        if (!temps.exists()) {
            System.err.println("The data file does not exist.");
        } else {
            readFile(temps);
        }
    }

    public static void readFile (File file) {
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line;
            int counter = 0;
            while ((line = in.readLine()) != null) {
                counter++;
                System.out.println("average for line " + counter + ": " + getLineAverage(line));
            }
        } catch (FileNotFoundException ex) {
            System.err.println("The data file does not exist.");
        } catch (IOException ex) {
            System.err.println("Encountered an error while reading the data file.");
            ex.printStackTrace();
        }
    }

    public static Integer getLineAverage(String line) {
        Integer count = 0;
        Integer total = 0;
        String[] temps = line.split(", ");
        for (String s : temps) {
            // need to figure
            Integer current = 0;
            boolean didParse = false;
            try {
                current = Integer.parseInt(s);
                didParse = true;
            } catch (NumberFormatException ex) {
                System.err.println("Invalid number: " + s);
            }
            if (didParse) {
                total = total + current;
                count++;
            }
        }
        if (count != 0) {
            return total / count;
        } else {
            return 0;
        }
    }
}
