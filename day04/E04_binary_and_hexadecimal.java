import java.util.Scanner;public class E04_binary_and_hexadecimal { public static void main(String[] args) {
            //

            System.out.println("Enter a decimal number or hexadecimal (starts with 0x):");
        String str = System.console().readLine();
        if(str.substring(0,2).equals("0x")) {
            int decimal = hexToDecimal(str.substring(2));
            System.out.println(decimal);
        } else {
            int dec = Integer.parseInt(str);
            String hex = decimalToHex(dec);
            System.out.println(hex);
        }
    }

    private static int power(int base, int exponent) {
        int powered = 1;
        for (int i = 0; i < exponent; i++) {
            powered = powered * base;
        }
        return powered;
    }

    private static int power16(int num) {
        return power(16, num);
    }

    private static String getHexForValue(int val) {
        if (val <= 0) {
            return "0";
        }
        String result = "";
        switch (val) {
            case 15:
                result = "f";
                break;
            case 14:
                result = "e";
                break;
            case 13:
                result = "d";
                break;
            case 12:
                result = "c";
                break;
            case 11:
                result = "b";
                break;
            case 10:
                result = "a";
                break;
            default:
                result = "" + val;
                break;
        }
        return result;
    }

    private static String decimalToHex(int dec) {
        String hex = "0x";
        int remainder;
        for (int i = dec; i > 0; i /= 16) {
            System.out.println(i);
            remainder = i % 16;
            System.out.println(remainder);
            hex += getHexForValue(remainder);
        }
        return hex;
    }

    private static int hexToDecimal(String str) {
        int len = str.length();
        int dec = 0;
        int exponent;
        for (int i = 0; i < len; i++) {
            int num;
            char thisChar = str.charAt(i);
            exponent = (len - 1 - i);
            switch (thisChar) {
                case 'a':
                    num = 10;
                    break;
                case 'b':
                    num = 11;
                    break;
                case 'c':
                    num = 12;
                    break;
                case 'd':
                    num = 13;
                    break;
                case 'e':
                    num = 14;
                    break;
                case 'f':
                    num = 15;
                    break;
                default:
                    num = Integer.parseInt("" + thisChar);
                    break;
            }
            if (num > 0) {
                dec += (num * power16(exponent));
            }
        }
        return dec;
    }

    private static Scanner __input = new Scanner(System.in);

    public static String readLine()  { return __input.nextLine(); }

    public static int    readInt()   { return Integer.parseInt(readLine());  }

    public static double readdouble(){ return Double.parseDouble(readLine());}

}