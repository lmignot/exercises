/**
 * Testing a Library User
 */

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LibraryUserTest {

    @Test
    public void basicUserTest () {
        String name = "Janet Smitherton";

        LibraryUser user = new LibraryUserImpl(name);

        assertThat(user.getFullName()).isEqualTo(name);
        assertThat(user.getLibraryId()).isNotNegative();
    }
}
