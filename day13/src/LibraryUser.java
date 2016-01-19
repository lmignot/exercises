/**
 * A Library user
 */
public interface LibraryUser {

    /**
     * Retrieves the full name for this particular Library user
     * @return The user's name
     */
    String getFullName();

    /**
     * Retrieves the Library Id for this particular user
     * @return The user's Library ID
     */
    int getLibraryId();

    /**
     * Registers this user with a given Library
     * @param library the Library with which to register this user
     * @return The user's library ID
     */
    int register(Library library);
}
