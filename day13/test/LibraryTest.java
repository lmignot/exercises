import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

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
        assertThat(library.getLibrary().equals(libraryName));
        assertEquals(library.getMaxBooksPerUser(), 3);
    }

    @Test
    public void testLibraryRegisterUsers () {
        assertEquals(library.getId(testUserName), testUserId);
        assertEquals(library.getId("Henry Ford"), 1);

        LibraryUser user = new LibraryUserImpl("Samuel L. Jackson");
        user.register(library);

        assertEquals(library.getId("Samuel L. Jackson"), user.getLibraryId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLibraryGetIdWithNullArgument () {
        library.getId(null);
    }
}
