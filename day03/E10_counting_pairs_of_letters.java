
import java.util.Scanner;

public class E10_counting_pairs_of_letters { 
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
            // the program should find every match of aaa - in this case 11

            System.out.println("Enter 2-3 letters:");
        String letters = input.nextLine();
        System.out.println("Enter a sentence:");
        String sentence = input.nextLine();
        int len = sentence.length();
        int shortLen = letters.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (compareLettersAtStringPosition(i, letters, sentence)) {
                count++;
            }
        }
        if (count > 0) {
            System.out.println("The letters " + letters + " appeared " + count + " times in your sentence.");
        } else {
            System.out.println("The letters did not appear in the sentence.");
        }
    }

    private static boolean compareLettersAtStringPosition(int i, String letters, String sentence) {
        int j = i;
        int lettersLen = letters.length() + i;
        int sentenceLen = sentence.length();
        String compare = "";
        while (j < lettersLen) {
            if (j < sentenceLen) {
                compare += sentence.charAt(j);
            }
            j++;
        }
        return areStringsEqual(letters, compare);
    }

    private static boolean areStringsEqual(String strA, String strB) {
        int len = strA.length();
        int len2 = strB.length();
        if (len != len2) {
            return false;
        }
        int foundEquals = 0;
        for (int i = 0; i < len; i++) {
            if(strA.charAt(i) == strB.charAt(i)) {
                foundEquals++;
            }
        }
        return (foundEquals == len);
    }
}