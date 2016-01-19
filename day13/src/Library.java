/**
 * Interface describing a Library
 */
public interface Library {

    /**
     * Retrieve the name of this Library
     * @return The name of the Library
     */
    String getLibrary();

    /**
     * Retrieve the ID of a user within this Library
     * If there is no user found, generates a new Id for the given user
     * @return The user's Library ID
     */
    int getId(String userName);
}
