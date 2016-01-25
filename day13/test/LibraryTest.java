import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Testing a Library
 */
public class LibraryTest {

    private Library library;
    private String libraryName = "Laurent's Library";

    private String testUserName = "Laurent Mignot";
    private int testUserId = 0;

    @Before
    public void setUp () {
        library = new LibraryImpl(libraryName);
    }

    @After
    public void tearDown () {
        library = null;
    }

    @Test
    public void testConstructLibrary () {
        assertThat(library.getLibrary()).isEqualTo(libraryName);
        assertThat(library.getMaxBooksPerUser()).isEqualTo(3);
    }

    @Test
    public void testChangeMaxBooksPerUser () {
        library.setMaxBooksPerUser(5);
        assertThat(library.getMaxBooksPerUser()).isEqualTo(5);
    }

    @Test
    public void testLibraryRegisterUsers () {
        assertThat(library.getId(testUserName)).isEqualTo(testUserId);
        assertThat(library.getId("Henry Ford")).isEqualTo(1);

        LibraryUser user = new LibraryUserImpl("Samuel L. Jackson");
        user.register(library);

        assertThat(library.getId("Samuel L. Jackson")).isEqualTo(user.getLibraryId());
    }

    @Test
    public void testLibraryRegisterExistingUser () {
        int idA = library.getId("John Smith");
        int idB = library.getId("John Smith");
        assertThat(idA).isEqualTo(idB);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLibraryGetIdWithNullArgument () {
        library.getId(null);
    }

    @Test
    public void testAddNewBookToLibrary () {
        assertThat(library.addBook("Harry Potter and the Deathly Hallows", "J.K. Rowling")).isTrue();
    }

    @Test
    public void testAddExistingBookToLibrary () {
        library.addBook("Harry Potter and the Deathly Hallows", "J.K. Rowling");
        assertThat(library.addBook("Harry Potter and the Deathly Hallows", "J.K. Rowling")).isFalse();
    }

    @Test
    public void testAddInvalidBookToLibrary () {
        assertThat(library.addBook("Harry Potter and the Deathly Hallows", null)).isFalse();
        assertThat(library.addBook(null, "J.K. Rowling")).isFalse();
        assertThat(library.addBook(null, null)).isFalse();
        assertThat(library.addBook("", "")).isFalse();
        assertThat(library.addBook(null, "")).isFalse();
        assertThat(library.addBook("", null)).isFalse();
        assertThat(library.addBook("", "J.K. Rowling")).isFalse();
        assertThat(library.addBook("Harry Potter and the Deathly Hallows", "")).isFalse();
    }

    @Test
    public void testBorrowBookFromLibrary () {
        Book book = new BookImpl("Harry Potter and the Deathly Hallows", "J.K. Rowling");
        library.addBook("Harry Potter and the Deathly Hallows", "J.K. Rowling");
        Book borrowed = library.takeBook("Harry Potter and the Deathly Hallows");

        assertThat(book.getTitle()).isEqualTo(borrowed.getTitle());
        assertThat(book.getAuthor()).isEqualTo(borrowed.getAuthor());
    }

    @Test
    public void testBorrowInvalidBookFromLibrary () {
        assertThat(library.takeBook(null)).isNull();
    }

    @Test
    public void testReturnBorrowedBookToLibrary () {
        library.addBook("Wolf Hall", "Hilary Mantel");
        Book borrowed = library.takeBook("Wolf Hall");

        boolean returned = library.returnBook(borrowed);

        assertThat(returned).isTrue();
    }

    @Test
    public void testReturnInvalidBorrowedBookToLibrary () {
        assertThat(library.takeBook(null)).isNull();
        assertThat(library.takeBook("")).isNull();
    }

    @Test
    public void testBorrowAlreadyBorrowedBookFromLibrary () {
        library.addBook("Harry Potter and the Deathly Hallows", "J.K. Rowling");
        library.takeBook("Harry Potter and the Deathly Hallows");
        Book borrowed = library.takeBook("Harry Potter and the Deathly Hallows");

        assertThat(borrowed).isNull();
    }

    @Test
    public void testBorrowNonExistingBookFromLibrary () {
        Book borrowed = library.takeBook("Fear and Loathing in Las Vegas");

        assertThat(borrowed).isNull();
    }

    @Test
    public void testReturnAnyOldBookToLibrary () {
        Book myBook = new BookImpl("My Memoirs", "Laurent Mignot");
        boolean returned = library.returnBook(myBook);

        assertThat(returned).isFalse();
    }

    @Test
    public void testReturnBookThatWasNotBorrowedToLibrary () {
        library.addBook("Harry Potter and the Deathly Hallows", "J.K. Rowling");
        Book toReturn = new BookImpl("Harry Potter and the Deathly Hallows", "J.K. Rowling");

        boolean returned = library.returnBook(toReturn);

        assertThat(returned).isFalse();
    }

    @Test
    public void testLibraryUserCount () {
        library.getId(testUserName);
        library.getId("Henry Ford");
        library.getId("Samuel L. Jackson");
        library.getId("Thomas Edison");
        library.getId("Albert Einstein");
        library.getId("Robert DeNiro");
        library.getId("Leonardo Davinci");
        library.getId("John Smith");
        library.getId("Janet Doe");

        assertThat(library.getReaderCount()).isGreaterThan(0);
        assertThat(library.getReaderCount()).isEqualTo(9);
    }

    @Test
    public void testLibraryBookCount () {
        assertThat(library.getBookCount()).isEqualTo(0);

        library.addBook("Harry Potter and the Deathly Hallows", "J.K. Rowling");
        library.addBook("Wolf Hall", "Hilary Mantel");
        library.addBook("Fear and Loathing in Las Vegas", "Hunter S. Thompson");

        assertThat(library.getBookCount()).isGreaterThan(0);
        assertThat(library.getBookCount()).isEqualTo(3);
    }

    @Test
    public void testLibraryBookCountAfterInvalidAdding () {
        assertThat(library.getBookCount()).isEqualTo(0);

        library.addBook(null, "J.K. Rowling");
        library.addBook("Wolf Hall", null);
        library.addBook(null, null);
        library.addBook("", null);
        library.addBook(null, "");
        library.addBook("", "");

        assertThat(library.getBookCount()).isEqualTo(0);
    }

    @Test
    public void testLibraryBookCountEmptyLibrary () {
        assertThat(library.getBookCount()).isEqualTo(0);
    }

    @Test
    public void testLibraryBookCountAfterBorrowing () {
        assertThat(library.getBookCount()).isEqualTo(0);

        library.addBook("Harry Potter and the Deathly Hallows", "J.K. Rowling");
        library.addBook("Wolf Hall", "Hilary Mantel");
        library.addBook("Fear and Loathing in Las Vegas", "Hunter S. Thompson");

        assertThat(library.getBookCount()).isGreaterThan(0);
        assertThat(library.getBookCount()).isEqualTo(3);

        library.takeBook("Fear and Loathing in Las Vegas");

        assertThat(library.getBookCount()).isGreaterThan(0);
        assertThat(library.getBookCount()).isEqualTo(3);
    }

    @Test
    public void testLibraryBookCountAfterBorrowingAlreadyTakenBook () {
        library.addBook("Harry Potter and the Deathly Hallows", "J.K. Rowling");
        library.addBook("Wolf Hall", "Hilary Mantel");
        library.addBook("Fear and Loathing in Las Vegas", "Hunter S. Thompson");

        library.takeBook("Fear and Loathing in Las Vegas");
        library.takeBook("Wolf Hall");
        library.takeBook("Harry Potter and the Deathly Hallows");
        library.takeBook("Harry Potter and the Deathly Hallows");

        assertThat(library.getBookCount()).isGreaterThan(0);
        assertThat(library.getBookCount()).isEqualTo(3);
    }

    @Test
    public void testLibraryBookCountAfterInvalidBorrowing () {
        assertThat(library.getBookCount()).isEqualTo(0);

        library.addBook("Harry Potter and the Deathly Hallows", "J.K. Rowling");
        library.addBook("Wolf Hall", "Hilary Mantel");
        library.addBook("Fear and Loathing in Las Vegas", "Hunter S. Thompson");

        assertThat(library.getBookCount()).isGreaterThan(0);
        assertThat(library.getBookCount()).isEqualTo(3);

        library.takeBook(null);
        library.takeBook("");
        library.takeBook("John Doe's History");

        assertThat(library.getBookCount()).isGreaterThan(0);
        assertThat(library.getBookCount()).isEqualTo(3);
    }

    @Test
    public void testLibraryBookCountAfterReturning () {
        library.addBook("Harry Potter and the Deathly Hallows", "J.K. Rowling");
        library.addBook("Wolf Hall", "Hilary Mantel");
        library.addBook("Fear and Loathing in Las Vegas", "Hunter S. Thompson");

        Book book = library.takeBook("Fear and Loathing in Las Vegas");
        Book book2 = library.takeBook("Wolf Hall");
        Book book3 = library.takeBook("Harry Potter and the Deathly Hallows");

        library.returnBook(book);
        library.returnBook(book2);
        library.returnBook(book3);

        assertThat(library.getBookCount()).isGreaterThan(0);
        assertThat(library.getBookCount()).isEqualTo(3);
    }

    @Test
    public void testLibraryBookCountAfterInvalidReturning () {
        Book book = library.takeBook("");
        Book book2 = library.takeBook(null);

        library.returnBook(book);
        library.returnBook(book2);

        assertThat(library.getBookCount()).isEqualTo(0);
    }

    @Test
    public void testLibraryBorrowedBookCount () {
        library.addBook("Harry Potter and the Deathly Hallows", "J.K. Rowling");
        library.addBook("Wolf Hall", "Hilary Mantel");
        library.addBook("Fear and Loathing in Las Vegas", "Hunter S. Thompson");

        library.takeBook("Fear and Loathing in Las Vegas");
        library.takeBook("Wolf Hall");

        assertThat(library.getBookBorrowedCount()).isEqualTo(2);
        assertThat(library.getBookCount()).isEqualTo(3);
    }

    @Test
    public void testLibraryBorrowedBookCountAfterReturning () {
        library.addBook("Harry Potter and the Deathly Hallows", "J.K. Rowling");
        library.addBook("Wolf Hall", "Hilary Mantel");
        library.addBook("Fear and Loathing in Las Vegas", "Hunter S. Thompson");

        Book book = library.takeBook("Wolf Hall");
        library.returnBook(book);

        assertThat(library.getBookBorrowedCount()).isEqualTo(0);

        Book book2 = library.takeBook("Fear and Loathing in Las Vegas");
        library.returnBook(book2);

        assertThat(library.getBookBorrowedCount()).isEqualTo(0);

        book = library.takeBook("Wolf Hall");
        book2 = library.takeBook("Fear and Loathing in Las Vegas");

        library.returnBook(book);
        library.returnBook(book2);

        assertThat(library.getBookBorrowedCount()).isEqualTo(0);
    }

    @Test
    public void testLibraryBorrowedBookCountAfterInvalidReturning () {
        library.addBook("Harry Potter and the Deathly Hallows", "J.K. Rowling");
        library.addBook("Wolf Hall", "Hilary Mantel");
        library.addBook("Fear and Loathing in Las Vegas", "Hunter S. Thompson");

        library.returnBook(null);

        assertThat(library.getBookBorrowedCount()).isEqualTo(0);
    }

    @Test
    public void testLibraryBorrowedBookCountAfterInvalidBorrowing () {
        library.addBook("Harry Potter and the Deathly Hallows", "J.K. Rowling");
        library.addBook("Wolf Hall", "Hilary Mantel");
        library.addBook("Fear and Loathing in Las Vegas", "Hunter S. Thompson");

        library.takeBook("");
        library.takeBook(null);

        assertThat(library.getBookBorrowedCount()).isEqualTo(0);
    }
}
