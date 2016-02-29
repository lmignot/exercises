import java.util.List;
import java.util.stream.Collectors;

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

    public static List<String> allMatches (List<String> input, SinglePredicate fn) {
        return input.stream().filter(fn::matches).collect(Collectors.toList());
    }

}
