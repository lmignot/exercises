import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Testing YoungPatient Implementation
 */
public class PatientTest {

    @Test
    public void basePatientTest () {
        YoungPatient pete = new YoungPatient("Peter Davis", 45, "Gonnorhaea");

        assertThat(pete.getName()).isEqualTo("Peter Davis");
        assertThat(pete.getAge()).isEqualTo(45);
        assertThat(pete.getIllness()).isEqualTo("Gonnorhaea");
    }

    @Test(expected = IllegalArgumentException.class)
    public void patientShouldThrowIfTooYoung () {
        YoungPatient young = new YoungPatient("Reverso", -4, "Reverse aging");
    }

    @Test(expected = IllegalArgumentException.class)
    public void patientShouldThrowIfTooOld () {
        YoungPatient old = new YoungPatient("Way Too Oldio", 198, "Should be dead");
    }
}
