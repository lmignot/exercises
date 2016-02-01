/**
 * This is a Hospital interface
 * It describes a hospital
 */
public interface Hospital {

    /**
     * Ask a user for information about a Patient and
     * add a new Patient using the information provided
     * @return True if the Patient was added, false if not
     */
    boolean addPatient();

    String getName();
}
