import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of a Library
 * @see Library
 */
public class LibraryImpl implements Library{

    private final String name;
    private int maxBooksPerUser = 3;

    private List<RegisteredLibraryUser> libraryUsers;
    private List<Book> availableBooks;
    private List<Book> booksOnLoan;

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
            for (RegisteredLibraryUser u : libraryUsers) {
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
        if (title == null || author == null || title.equals("") || author.equals("")) {
            return false;
        }
        boolean didAddBook = false;
        boolean isAvailable = this.isBookInList(title, this.availableBooks);
        boolean isOnLoan = this.isBookInList(title, this.booksOnLoan);
        if (!isAvailable && !isOnLoan) {
            didAddBook = this.availableBooks.add(new BookImpl(title, author));
        }
        return didAddBook;
    }

    /**
     * @see Library#takeBook(String)
     */
    @Override
    public Book takeBook(String title) {
        if (title == null || title.equals("")) {
            return null;
        }
        boolean isAvailable = this.isBookInList(title, this.availableBooks);
        boolean isOnLoan = this.isBookInList(title, this.booksOnLoan);
        if(!isAvailable && !isOnLoan) {
            return null;
        } else if (isOnLoan) {
            return null;
        } else {
            String bTitle = "";
            String bAuthor = "";
            Book found = null;
            for (Book b : this.availableBooks) {
                if (b.getTitle().equals(title)) {
                    bTitle = b.getTitle();
                    bAuthor = b.getAuthor();
                    found = b;
                    break;
                }
            }
            this.availableBooks.remove(found);
            this.booksOnLoan.add(found);
            return new BookImpl(bTitle, bAuthor);
        }
    }

    /**
     * @see Library#returnBook(Book)
     */
    @Override
    public boolean returnBook(Book book) {
        if (book == null) {
            return false;
        }
        boolean isOnLoan = this.isBookInList(book.getTitle(), this.booksOnLoan);
        if (!isOnLoan) {
            return false;
        } else {
            Book found = null;
            for (Book b : this.booksOnLoan) {
                if (b.getTitle().equals(book.getTitle())) {
                    found = b;
                    break;
                }
            }
            this.booksOnLoan.remove(found);
            this.availableBooks.add(found);
            return true;
        }
    }

    /**
     * Determine if a book is already in the library
     * @param title The title of the book to search for
     * @return True if the book already exists, false if not
     */
    private boolean isBookInList(String title, List<Book> listToSearch) {
        if (listToSearch.isEmpty()) {
            return false;
        } else {
            boolean isInLibrary = false;
            for (Book b : listToSearch) {
                if (b.getTitle().equals(title)) {
                    isInLibrary = true;
                    break;
                }
            }
            return isInLibrary;
        }
    }

    /**
     * @see Library#getReaderCount()
     */
    @Override
    public int getReaderCount() {
        return this.libraryUsers.size();
    }

    /**
     * @see Library#getBookCount()
     */
    @Override
    public int getBookCount() {
        return this.availableBooks.size() + this.booksOnLoan.size();
    }

    /**
     * @see Library#getBookBorrowedCount()
     */
    @Override
    public int getBookBorrowedCount() {
        return this.booksOnLoan.size();
    }
}
