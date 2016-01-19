/**
 * A Book
 * Custom class defining a Book
 * Books have authors and titles
 * A Book's author and title never change for a given edition
 */
public interface Book {

    /**
     * Retrieves the author of this book
     * @return The book's author
     */
    String getAuthor();

    /**
     * Retrieves the title of this book
     * @return The book's title
     */
    String getTitle();
}
