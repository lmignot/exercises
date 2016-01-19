/**
 * Testing a Book
 */

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BookTest {

    @Test
    public void bookTest () {
        String author = "Stephen King";
        String title = "It";

        Book b = new BookImpl(title, author);

        assertThat(b).isNotNull();

        assertThat(b.getTitle()).isNotEmpty();
        assertThat(b.getAuthor()).isNotEmpty();

        assertThat(b.getTitle()).isEqualTo(title);
        assertThat(b.getAuthor()).isEqualTo(author);
    }
}
