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
    public void testBorrowBookFromLibrary () {
        Book book = new BookImpl("Harry Potter and the Deathly Hallows", "J.K. Rowling");
        library.addBook("Harry Potter and the Deathly Hallows", "J.K. Rowling");
        Book borrowed = library.takeBook("Harry Potter and the Deathly Hallows");

        assertThat(book.getTitle()).isEqualTo(borrowed.getTitle());
        assertThat(book.getAuthor()).isEqualTo(borrowed.getAuthor());
    }

    @Test
    public void testReturnBorrowedBookToLibrary () {
        library.addBook("Wolf Hall", "Hilary Mantel");
        Book borrowed = library.takeBook("Wolf Hall");

        boolean returned = library.returnBook(borrowed);

        assertThat(returned).isTrue();
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
}
