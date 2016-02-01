import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Day 15 - exercise 3 - User input
 */
public class MeanCalculator {

    private final int MAX_INPUT = 10;

    public static void main (String[] args) {
        MeanCalculator calc = new MeanCalculator();
        calc.launch();
    }

    private void launch () {
        List<Integer> capturedNumbers = new ArrayList<>(MAX_INPUT);
        Scanner sc = new Scanner(System.in);
        int currentNum = 0;

        while (currentNum < MAX_INPUT) {
            capturedNumbers.add(getInteger(sc));
            currentNum++;
        }

        System.out.println("The mean average is: " + getMean(capturedNumbers));
    }

    private int getInteger (Scanner scanner) {
        boolean valid = false;
        int result = 0;
        do {
            try {
                System.out.print("Enter a number: ");
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
