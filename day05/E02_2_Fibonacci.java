import java.util.Scanner;public class E02_2_Fibonacci { public static void main(String[] args) {
            //

            System.out.println("fibonacci recursive, 1st place is: " + fibRec(1));
        System.out.println("fibonacci recursive, 2nd place is: " + fibRec(2));
        System.out.println("fibonacci recursive, 3rd place is: " + fibRec(3));
        System.out.println("fibonacci recursive, 4th place is: " + fibRec(4));
        System.out.println("fibonacci recursive, 5th place is: " + fibRec(5));
        System.out.println("fibonacci recursive, 6th place is: " + fibRec(6));
        System.out.println("fibonacci recursive, 7th place is: " + fibRec(7));
        System.out.println("fibonacci recursive, 8th place is: " + fibRec(8));
        System.out.println("");
        System.out.println("fibonacci iterative, 1st place is: " + fibIter(1));
        System.out.println("fibonacci iterative, 2nd place is: " + fibIter(2));
        System.out.println("fibonacci iterative, 3rd place is: " + fibIter(3));
        System.out.println("fibonacci iterative, 4th place is: " + fibIter(4));
        System.out.println("fibonacci iterative, 5th place is: " + fibIter(5));
        System.out.println("fibonacci iterative, 6th place is: " + fibIter(6));
        System.out.println("fibonacci iterative, 7th place is: " + fibIter(7));
        System.out.println("fibonacci iterative, 8th place is: " + fibIter(8));
    }

    private static int fibIter (int n) {
        if (n <= 1) {
            return n;
        }
        int fib = 1;
        int prev = 1;
        for (int i = 2; i < n; i++) {
            int tmp = fib;
            fib += prev;
            prev = tmp;
        }
        return fib;
    }

    private static int fibRec (int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibRec(n - 1) + fibRec(n - 2);
        }
    }

    private static Scanner __input = new Scanner(System.in);

    public static String readLine()  { return __input.nextLine(); }

    public static int    readInt()   { return Integer.parseInt(readLine());  }

    public static double readdouble(){ return Double.parseDouble(readLine());}

}