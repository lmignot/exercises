package SimpleMap;

/**
 * Map from integer to Strings
 */
public interface SimpleMap {
    /**
     * Puts a new String in the map.
     * If the key is in the map already, does nothing
     */
    void put (int key, String name);

    /**
     * Returns the name associated with the key
     * or null if there is none.
     */
    String get (int key);

    /**
     * Removes a name from the map. Future calls to get(key)
     * will return null for this key unless another name has been added
     * with this same key
     */
    void remove (int key);

    /**
     * @return true if no entries in map, false otherwise
     */
    boolean isEmpty ();
}
