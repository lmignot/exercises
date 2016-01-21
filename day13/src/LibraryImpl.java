import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of a Library
 * @see Library
 */
public class LibraryImpl implements Library{

    private final String name;
    private int maxBooksPerUser = 3;

    private List<RegisteredLibraryUserImpl> libraryUsers;
    private List<BookImpl> availableBooks;
    private List<BookImpl> booksOnLoan;

    LibraryImpl(String name) {
        this.name = name;
        this.libraryUsers = new ArrayList<>();
        this.availableBooks = new ArrayList<>();
        this.booksOnLoan = new ArrayList<>();
    }

    /**
     * @see Library#getLibrary()
     */
    @Override
    public String getLibrary() {
        return this.name;
    }

    /**
     * @see Library#getId(String)
     */
    @Override
    public int getId(String userName) {
        if (userName == null) {
            throw new IllegalArgumentException();
        }
        int id = 0;
        // if it's empty, start at id 0
        if (this.libraryUsers.isEmpty()) {
            libraryUsers.add(new RegisteredLibraryUserImpl(userName, id));
        } else {
            for (RegisteredLibraryUserImpl u : libraryUsers) {
                // check if the user is already registered
                // and return their id
                if (u.getUserName().equals(userName)) {
                    return u.getUserId();
                } else {
                    id = u.getUserId();
                }
            }
            // add the new user with the next id
            id = id + 1;
            libraryUsers.add(new RegisteredLibraryUserImpl(userName, id));
        }
        return id;
    }

    /**
     * @see Library#getMaxBooksPerUser()
     */
    @Override
    public int getMaxBooksPerUser() {
        return this.maxBooksPerUser;
    }

    /**
     * @see Library#setMaxBooksPerUser(int)
     */
    @Override
    public void setMaxBooksPerUser(int newMax) {
        this.maxBooksPerUser = newMax;
    }

    /**
     * @see Library#addBook(String, String)
     */
    @Override
    public boolean addBook(String title, String author) {
        return false;
    }

    /**
     * @see Library#takeBook(String)
     */
    @Override
    public Book takeBook(String title) {
        return null;
    }

    /**
     * @see Library#returnBook(Book)
     */
    @Override
    public boolean returnBook(Book book) {
        return false;
    }
}
