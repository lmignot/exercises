import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Day 15 - exercise 1 - CodeFlow
 */
public class CodeFlow {


    public static void main(String[] args) {
        Scanner sm = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String input = sm.nextLine();
        int inNum = Integer.parseInt(input);

        CodeFlow launcher = new CodeFlow();
        launcher.launch(inNum);
    }

    private void launch (int userInput) {
        List<Integer> intList = new ArrayList<>();

        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);

        try {
            intList.remove(0);
            System.out.println(intList.get(userInput));
            intList.remove(0);
            System.out.println(intList.get(userInput));
            intList.remove(0);
            System.out.println(intList.get(userInput));
            intList.remove(0);
            System.out.println(intList.get(userInput));
            intList.remove(0);
            System.out.println(intList.get(userInput));
            intList.remove(0);
            System.out.println(intList.get(userInput));
            intList.remove(0);
            System.out.println(intList.get(userInput));
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }
}
