import java.util.Scanner;public class E02_1_Factorial { public static void main(String[] args) {
            //

            System.out.println("Recursive factorial of 4 equals: " + factorialRecursive(4));
        System.out.println("Iterative factorial of 4 equals: " + factorialIterative(4));
        System.out.println("Recursive factorial of 8 equals: " + factorialRecursive(8));
        System.out.println("Iterative factorial of 8 equals: " + factorialIterative(8));
    }

    private static int factorialIterative (int n) {
        int result = n;
        n--;
        while (n >= 1) {
            result = result * n;
            n--;
        }
        return result;
    }

    private static int factorialRecursive (int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorialRecursive(n - 1);
        }
    }

    private static Scanner __input = new Scanner(System.in);

    public static String readLine()  { return __input.nextLine(); }

    public static int    readInt()   { return Integer.parseInt(readLine());  }

    public static double readdouble(){ return Double.parseDouble(readLine());}

}