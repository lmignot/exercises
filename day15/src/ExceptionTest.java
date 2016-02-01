/**
 * Day 15 - exercise 2 - Exception
 * The less specific Exception will be caught so it will
 * never reach the more specific exception below it
 * Exception handling code should catch more specific exceptions first
 *
 * Exception itself cannot be caught, one of the subclasses should be used.
 */
public class ExceptionTest {

    public static void main (String[] args) {
        int a = 9;
        int b = 0;
        int result = 0;
        try {
            result = a / b;
        } catch (ArithmeticException ex) {
            ex.printStackTrace();
        }

        System.out.println(a + " divided by " + b + " equals: " + result);
    }
}
