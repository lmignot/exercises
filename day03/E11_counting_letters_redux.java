
import java.util.Scanner;

public class E11_counting_letters_redux { 
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
            //

            System.out.println("Please enter some text:");
        String sentence = input.nextLine();
        boolean isFinished = false;
        String lettersCounted = "";
        while(!isFinished) {
            System.out.println("Which letter would you like to count now?");
            String str = input.nextLine();
            char letter = str.charAt(0);
            int letterCount = 0;
            if (countLetterRepetitionInSentence(letter, lettersCounted) > 0) {
                System.out.println("Repeated character, exiting...");
                System.out.println("So long... and thanks for all the fish");
                isFinished = true;
            } else {
                lettersCounted += letter;
                letterCount = countLetterRepetitionInSentence(letter, sentence);
                System.out.println("There " + (letterCount > 1 ? "are " : "is ") + letterCount + " in your text.");
            }
        }
    }

    private static int countLetterRepetitionInSentence(char letter, String sentence) {
        int len = sentence.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (sentence.charAt(i) == letter) {
                count++;
            }
        }
        return count;
    }
}