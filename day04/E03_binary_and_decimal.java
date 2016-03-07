
import java.util.Scanner;

public class E03_binary_and_decimal { 
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
            //

            System.out.println("What would you like to do today?");
        System.out.println("1. Convert binary to decimal");
        System.out.println("2. Convert decimal to binary");
        int choice = Integer.parseInt(input.nextLine());
        switch(choice) {
            case 1:
                System.out.println("Enter the binary number:");
                String binaryEntry = input.nextLine();
                binary2decimal(binaryEntry);
                break;
            case 2:
                System.out.println("Enter the decimal number:");
                int decimalEntry = Integer.parseInt(input.nextLine());
                decimal2binary(decimalEntry);
                break;
            default: System.out.println("Invalid selection, exiting...");
        }
    }

    private static int power(int base, int exponent) {
        int powered = 1;
        for (int i = 0; i < exponent; i++) {
            powered = powered * base;
        }
        return powered;
    }

    private static int power2(int num) {
        return power(2, num);
    }

    private static String reverse(String str) {
        String reverse = "";
        int len = str.length();
        for (int i = len - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        return reverse;
    }

    private static void binary2decimal(String entry) {
        int len = entry.length();
        int converted = 0;
        int exponent;
        for (int i = 0; i < len; i++) {
            if(entry.charAt(i) == '1') {
                exponent = (len - 1 - i);
                converted += power2(exponent);
            }
        }
        System.out.println(entry + " converted to decimal is: " + converted);
    }

    private static void decimal2binary(int num) {
        String converted = "";
        while (num > 0) {
            converted += (num % 2 != 0) ? "1" : "0";
            num = num / 2;
        }
        converted = reverse(converted);
        System.out.println(num + " converted to binary is: " + converted);
    }
}