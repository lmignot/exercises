import java.util.Scanner;public class E01_Recursive_b { public static void main(String[] args) {
            //

            System.out.println(buggyMethod(6));
    }

    private static String buggyMethod(int n) {
        if (n <= 0) {
            return "";
        }
        return n + " " + buggyMethod(n - 2);
    }

    private static Scanner __input = new Scanner(System.in);

    public static String readLine()  { return __input.nextLine(); }

    public static int    readInt()   { return Integer.parseInt(readLine());  }

    public static double readdouble(){ return Double.parseDouble(readLine());}

}