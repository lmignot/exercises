/**
 * Interface describing a Library
 * Libraries have a name set at Construction time
 * They also have methods to assign an Id to users
 * A Library has a maximum number of a books a user is allowed to borrow at
 * one time
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

    /**
     * Retrieve the maximum number of books a user can borrow
     * @return The maximum number of books a user can borrow
     */
    int getMaxBooksPerUser();
}
