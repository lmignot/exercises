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
    public void testLibraryRegisterUsers () {
        assertThat(library.getId(testUserName)).isEqualTo(testUserId);
        assertThat(library.getId("Henry Ford")).isEqualTo(1);

        LibraryUser user = new LibraryUserImpl("Samuel L. Jackson");
        user.register(library);

        assertThat(library.getId("Samuel L. Jackson")).isEqualTo(user.getLibraryId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLibraryGetIdWithNullArgument () {
        library.getId(null);
    }
}
