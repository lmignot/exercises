import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of a Hospital for PiJ day 15 exercise 4
 */
public class HospitalImpl implements Hospital {

    private List<YoungPatient> patients;
    private String name;

    public HospitalImpl (String name) {
        this.name = name;
        this.patients = new LinkedList<>();
    }

    /**
     * @return The name of the hospital
     */
    @Override
    public String getName () {
        return this.name;
    }

    /**
     * @see Hospital#addPatient()
     */
    @Override
    public boolean addPatient() {
        return false;
    }
}
