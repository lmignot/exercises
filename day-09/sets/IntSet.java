public interface IntSet {

    /**
     * adds a new number to the set. if int is there already nothing happens
     * @param int the number to add
     */
    void add (int n);

    /**
     * Check if the set contains a number
     * @param  int the number to find
     */
    boolean contains (int n);

    /**
     * like contains() but prints out each value checked on screen
     * @param  int the number to find
     */
    boolean containsVerbose (int n);

    /**
     * Returns a comma-separated list of all values in the set
     */
    String toString ();

}
