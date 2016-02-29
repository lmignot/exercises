/**
 * PiJ day 19 - exercise 4
 */
public class ElementUtils {

    private ElementUtils() {}

    public static <T> T betterElement (T a, T b, TwoElementPredicate<T> fn) {
        return (fn.isBetter(a, b) ? a : b);
    }
}
