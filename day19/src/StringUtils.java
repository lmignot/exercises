/**
 * PiJ day 19 - exercise 3
 */
public class StringUtils {

    private StringUtils () {}

    public static int eChecker (String a, String b)  {
        int result = 0;
        if (a.contains("e") && !b.contains("e")) {
            result = -1;
        } else if (b.contains("e") && !a.contains("e")) {
            result = 1;
        }
        return result;
    }

    public static String betterString (String a, String b, TwoStringPredicate fn) {
        return (fn.isBetter(a, b) ? a : b);
    }
}
