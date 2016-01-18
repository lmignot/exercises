/**
 * Test class for Start (day 11 - exercise 2)
 */

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ComparatorTest {

    @Test
    public void getMaxIntTest () {
        int a = 2409;
        int b = 34;
        int result = Comparator.getMax(a, b);

        assertThat(result).isEqualTo(a).isGreaterThan(b);

        a = -45678;

        assertThat(Comparator.getMax(a, b)).isEqualTo(b).isGreaterThan(a);
    }

    @Test
    public void getMaxDoubleTest () {
        double a = 19.89;
        double b = 34.15;

        assertThat(Comparator.getMax(a, b)).isEqualTo(b).isGreaterThan(a);

        a = -45678.90;
        b = -32.21;

        assertThat(Comparator.getMax(a, b)).isEqualTo(b).isGreaterThan(a);

        a = 48.7890;

        assertThat(Comparator.getMax(a, b)).isEqualTo(a).isGreaterThan(b);
    }

    @Test
    public void getMaxStringTest () {
        String a = "1987";
        String b = "2365";

        assertThat(Comparator.getMax(a, b)).isEqualTo(b);

        b = "-4563";

        assertThat(Comparator.getMax(a, b)).isEqualTo(a);
    }
}
