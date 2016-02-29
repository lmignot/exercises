/**
 * PiJ day 19 - exercise 3
 *
 * Interface for implementation by lambdas,
 * returns true for whichever String is better
 */
@FunctionalInterface
public interface TwoStringPredicate {

    /**
     * Return true if the first String is better than the second,
     * false otherwise.
     * Lambdas that implement this interface need to define what "better" means.
     */
    boolean isBetter (String a, String b);

}
