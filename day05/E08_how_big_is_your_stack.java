import java.util.Scanner;public class E08_how_big_is_your_stack { public static void main(String[] args) {
        //

        StackCounter stackCounter = new StackCounter();
        System.out.println("calling with 2, -1:");
        try  {
            stackCounter.pow(2, -1);
        } catch (Error e) {
            System.out.println(e);
            System.out.println("size of the stack in method calls is: " + stackCounter.getCalls());
        }
        stackCounter.resetCalls();
        System.out.println("calling with 8, -16:");
        try  {
            stackCounter.pow(8, -16);
        } catch (Error e) {
            System.out.println(e);
            System.out.println("size of the stack in method calls is: " + stackCounter.getCalls());
        }
        stackCounter.resetCalls();
        System.out.println("calling with 2, -80:");
        try  {
            stackCounter.pow(2, -80);
        } catch (Error e) {
            System.out.println(e);
            System.out.println("size of the stack in method calls is: " + stackCounter.getCalls());
        }
        stackCounter.resetCalls();
        System.out.println("calling with 34, -120:");
        try  {
            stackCounter.pow(34, -120);
        } catch (Error e) {
            System.out.println(e);
            System.out.println("size of the stack in method calls is: " + stackCounter.getCalls());
        }
        stackCounter.resetCalls();
    }
    static public class StackCounter {
        private int calls = 0;
        public int getCalls () {
            return this.calls;
        }
        public void resetCalls () {
            this.calls = 0;
        }
        public int pow (int base, int exponent) {
            this.calls++;
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