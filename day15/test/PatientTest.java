import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Testing Patient Implementation
 */
public class PatientTest {

    @Test
    public void basePatientTest () {
        Patient pete = new Patient("Peter Davis", 45, "Gonnorhaea");

        assertThat(pete.getName()).isEqualTo("Peter Davis");
        assertThat(pete.getAge()).isEqualTo(45);
        assertThat(pete.getIllness()).isEqualTo("Gonnorhaea");
    }

    @Test(expected = IllegalArgumentException.class)
    public void patientShouldThrowIfTooYoung () {
        Patient young = new Patient("Reverso", -4, "Reverse aging");
    }

    @Test(expected = IllegalArgumentException.class)
    public void patientShouldThrowIfTooOld () {
        Patient old = new Patient("Way Too Oldio", 198, "Should be dead");
    }
}
