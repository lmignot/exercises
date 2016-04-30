import java.util.List;
import java.util.function.Function;
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

    /**
     * Returns a new List containing all Strings in
     * input that return a positive result when fn is applied
     *
     * @param input the List to test against
     * @param fn the Predicate to test each String against
     * @return a new List with all the matched Strings
     */
    public static List<String> allMatches (List<String> input, SinglePredicate fn) {
        return input.stream().filter(fn::matches).collect(Collectors.toList());
    }

    /**
     * Transforms a List
     *
     * @param input the List to operate on
     * @param fn the Function to apply to each element in the List
     * @return a new List containing all elements in input with the fn applied
     */
    public static <T> List<T> transformList (List<T> input, Function<T,T> fn) {
        return input.stream().map(fn).collect(Collectors.toList());
    }

}
