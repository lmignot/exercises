package HashUtilities;

public class HashUtilities {

    /**
     * Returns a simple hash for a provided number. The hash will be between 0 and 1000 inclusive.
     * @param num The number to generate a hash for
     * @return The generated hash
     */
    public static int shortHash (int num) {
        return Math.abs(num % 1000);
    }
}
