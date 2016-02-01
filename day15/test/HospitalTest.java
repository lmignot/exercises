import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Testing Hospital
 */
public class HospitalTest {

    @Test
    public void buildAHospital() {
        String hName = "St Johns";
        Hospital h = new HospitalImpl(hName);

        assertThat(h.getName()).isEqualTo(hName);
    }
}
