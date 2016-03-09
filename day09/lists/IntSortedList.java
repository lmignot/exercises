package lists;

/**
 * Inteface implementing a tree as a sorted list
 */
public interface IntSortedList {

    /**
     * adds a new int to the list so that the list remains sorted
     * allows duplicates
     * @param n the int to add to the list
     */
    void add (int n);

    /**
     * returns whether the int is in the list or not
     * @param  n the int to search for
     */
    boolean contains (int n);


    /**
     * @return a comma-separated string containing the value of all elements in the list
     */
    String toString ();
}
