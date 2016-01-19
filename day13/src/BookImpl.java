/**
 * Implementation of a book
 * @see Book
 */
public class BookImpl implements Book {

    private final String author;
    private final String title;

    BookImpl (String title, String author) {
        this.title = title;
        this.author = author;
    }

    /**
     * @see Book#getAuthor()
     */
    @Override
    public String getAuthor() {
        return this.author;
    }

    /**
     * @see Book#getTitle()
     */
    @Override
    public String getTitle() {
        return this.title;
    }
}
