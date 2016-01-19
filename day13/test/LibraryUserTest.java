/**
 * Testing a Library User
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LibraryUserTest {

    Library library;

    @Before
    public void setUp () {
        library = new LibraryMock();
    }

    @After
    public void tearDown () {
        library = null;
    }

    @Test
    public void basicUserTest () {
        String name = "Janet Smitherton";

        LibraryUser user = new LibraryUserImpl(name);

        assertThat(user.getFullName()).isEqualTo(name);
        assertThat(user.register(library)).isEqualTo(library.getId(name));
        assertThat(user.getLibraryId()).isEqualTo(library.getId(name));
    }
}
