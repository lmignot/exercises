import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Day 15 - exercise 3 - User input
 */
public class MeanCalculator {

    public static void main (String[] args) {
        MeanCalculator calc = new MeanCalculator();
        calc.launch();
    }

    private void launch () {
        Scanner sc = new Scanner(System.in);
        int currentNum = 0;
        int howManyNumbers = 0;

        howManyNumbers = getInteger(sc, "How many numbers would you like to calculate the average for?");

        List<Integer> capturedNumbers = new ArrayList<>(howManyNumbers);

        while (currentNum < howManyNumbers) {
            capturedNumbers.add(getInteger(sc, "Enter the next number :"));
            currentNum++;
        }

        System.out.println("The mean average is: " + getMean(capturedNumbers));
    }

    private int getInteger (Scanner scanner, String inputMsg) {
        boolean valid = false;
        int result = 0;
        do {
            try {
                System.out.print(inputMsg);
                result = scanner.nextInt();
                valid = true;
            } catch (InputMismatchException ex) {
                System.out.println("That's not a valid Integer, please try again!");
            }
            // flush input because nextInt() does not capture \n
            scanner.nextLine();
        } while (!valid);
        return result;
    }

    private int getMean (List<Integer> input) {
        int sum = 0;
        for (Integer i : input) {
            sum = sum + i;
        }
        return sum / input.size();
    }
}
