
import java.util.Scanner;

public class E15_palindrome_redux { 
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
            //

            System.out.println("Enter some text:");
        String str = input.nextLine();
        str = stripSpacesAndPunctuation(str).toLowerCase();
        System.out.println("cleaned");
        System.out.println(str);
        System.out.println("The text entered is" + (isAPalindrome(str) ? "" : " not") + " a palindrome.");
    }

    private static boolean isAPalindrome(String phrase) {
        String reverse = "";
        int len = phrase.length();
        for (int i = len - 1; i >= 0; i--) {
            reverse += phrase.charAt(i);
        }
        return phrase.equals(reverse);
    }

    private static String stripSpacesAndPunctuation(String phrase) {
        String cleaned = "";
        int len = phrase.length();
        for (int i = 0; i < len; i++) {
            if (Character.isLetter(phrase.charAt(i))) {
                cleaned += phrase.charAt(i);
            }
        }
        return cleaned;
    }
}