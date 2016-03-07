import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * PiJ day 19 - exercise 4
 */
public class ElementUtils {

    private ElementUtils() {}

    public static <T> T betterElement (T a, T b, TwoElementPredicate<T> fn) {
        return (fn.isBetter(a, b) ? a : b);
    }

    /**
     * Returns a new List containing all elements in
     * input that return a positive result when fn is applied
     *
     * @param input the list to operate on
     * @param fn the Predicate to test against
     * @param <T> the input Type
     * @return a new List with all matches found in the input list
     */
    public static <T> List<T> allMatches (List<T> input, Predicate<T> fn) {
        return input.stream().filter(fn).collect(Collectors.toList());
    }

    /**
     * My attempt at a generic List transform utility
     * Took some fiddling around and reading on generics, especially regarding the
     * type parameters for the Function<>
     * Seems to work so long as the provided function is able to handle the different types
     *
     * @param input the list to transform
     * @param fn the function to apply to each element in the list
     * @param <I> the type of elements in input list
     * @param <O> the type of elements in output list
     * @return A list with each element from the original list transformed by fn
     */
    public static <I, O> List<O> transformList (List<I> input, Function<I,O> fn) {
        return input.stream().map(fn).collect(Collectors.toList());
    }
}
