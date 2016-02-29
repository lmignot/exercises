/**
 * PiJ day 19 - exercise 4
 *
 * Generic interface for implementation by lambdas,
 * returns whichever element is better
 */
public interface TwoElementPredicate<T> {

    /**
     * Return true if the first element is better than the second,
     * false otherwise.
     * Lambdas that implement this interface need to define what "better" means.
     */
    boolean isBetter(T a, T b);

}
