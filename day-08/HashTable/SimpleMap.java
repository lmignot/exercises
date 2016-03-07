package HashTable;

/**
 * Map from integer to Strings: one to many
 */
public interface SimpleMap {
    /**
     * Puts a new String in the map.
     */
    String put (int key, String name);

    /**
     * Returns all names associated with the key
     * or null if there is none.
     */
    String[] get (int key);

    /**
     * Removes a name from the map
     */
    void remove (int key, String name);

    /**
     * @return true if no entries in map, false otherwise
     */
    boolean isEmpty ();
}
