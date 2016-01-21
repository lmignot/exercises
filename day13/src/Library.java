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

    /**
     * Change the maximum number of books a user can borrow
     * @param newMax Number representing the new maximum books per user setting
     */
    void setMaxBooksPerUser(int newMax);

    /**
     * Add a book to the Library
     * @param title The title of the book
     * @param author The author of the book
     * @return True if the book was added, false if the book already exists
     */
    boolean addBook(String title, String author);

    /**
     * Take (borrow) a book from the Library
     * @param title The title of the book to borrow
     * @return The borrowed book, or null if the book has been taken or does not exist
     */
    Book takeBook(String title);

    /**
     * Return a borrowed book to the Library
     * @param book The book to return
     * @return True if the book is in the Library and was borrowed, False
     * if the book was not borrowed or if the book does not exist in the Library
     */
    boolean returnBook(Book book);
}
