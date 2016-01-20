/**
 * Interface for a class to maintain data for a user that has
 * registered with a Library
 */
public interface RegisteredLibraryUser {

    /**
     * Get the ID for this registered user
     * @return The ID for this registered user
     */
    int getUserId ();

    /**
     * Get this registered user's name
     * @return This user's name
     */
    String getUserName ();
}
