import java.util.Scanner;public class E04_palindrome { public static void main(String[] args) {
            //

            System.out.println("Enter some text:");
        String str = readLine();
        if (str.length() == 0) {
            System.out.println("You didn't enter any text!");
        } else {
            System.out.println("your text is " + (isPalindrome(str) ? "" : " not ") + "a palindrome");
        }
    }

    private static boolean isPalindrome(String str) {
        if(str.length() == 0 || str.length() == 1) {
            return true;
        }
        if(str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1, str.length() - 1));
        } else {
            return false;
        }
    }

    private static Scanner __input = new Scanner(System.in);

    public static String readLine()  { return __input.nextLine(); }

    public static int    readInt()   { return Integer.parseInt(readLine());  }

    public static double readdouble(){ return Double.parseDouble(readLine());}

}