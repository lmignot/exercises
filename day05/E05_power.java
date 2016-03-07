import java.util.Scanner;public class E05_power { public static void main(String[] args) {
        //

        CalculatePowerIterative calcIter = new CalculatePowerIterative();
        CalculatePowerRecursive calcRec = new CalculatePowerRecursive();
        System.out.println("2 to the power of 12, iterative: " + calcIter.pow(2, 12));
        System.out.println("8 to the power of 4, recursive: " + calcRec.pow(8, 4));
        System.out.println("2 to the power of -12, recursive: " + calcRec.pow(2, -12));
        System.out.println("4 to the power of 8 iterative == recursive: " + (calcIter.pow(4, 8) == calcRec.pow(4, 8)));
    }
    static class CalculatePowerIterative {
        int pow(int base, int exponent) {
            int result = 1;
            for (int i = 0; i < exponent; i++) {
                result = result * base;
            }
            return result;
        }
    }
    static class CalculatePowerRecursive {
        int pow(int base, int exponent) {
            if (exponent == 0) {
                return 1;
            } else {
                return base * pow(base, exponent - 1);
            }
        }
    }

    private static Scanner __input = new Scanner(System.in);

    public static String readLine()  { return __input.nextLine(); }

    public static int    readInt()   { return Integer.parseInt(readLine());  }

    public static double readdouble(){ return Double.parseDouble(readLine());}

}