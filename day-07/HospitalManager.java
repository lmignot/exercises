public class HospitalManager {
    private Patient firstPatientInList = null;

    public static void main(String[] args) {

        HospitalManager hm = new HospitalManager();

        Patient dave = new Patient("Dave", 32, "Hives");
        hm.firstPatientInList = dave;

        Patient bob = new Patient("Bob", 87, "Arrythmia");
        hm.firstPatientInList.addPatient(bob);

        Patient sara = new Patient("Sara", 72, "Heart disease");
        hm.firstPatientInList.addPatient(sara);

        Patient jill = new Patient("Jill", 99, "Age");
        hm.firstPatientInList.addPatient(jill);

        Patient jane = new Patient("Jane", 12, "Gentle warts");
        hm.firstPatientInList.addPatient(jane);

        Patient moh = new Patient("Mohammed", 22, "Psychosis");
        hm.firstPatientInList.addPatient(moh);

        hm.firstPatientInList.prettyPrintAll();

        System.out.println("Deleting Sara, Jane");

        hm.firstPatientInList.deletePatient(sara);
        hm.firstPatientInList.deletePatient(jane);

        hm.firstPatientInList.prettyPrintAll();

        System.out.println("Adding Jack");

        Patient jack = new Patient("Jack", 57, "Agoraphobia");
        hm.firstPatientInList.addPatient(jack);

        hm.firstPatientInList.prettyPrintAll();

        System.out.println("Deleting Mohammed");

        hm.firstPatientInList.deletePatient(moh);

        hm.firstPatientInList.prettyPrintAll();

        System.out.println("Deleting First patient");

        if (!hm.firstPatientInList.deletePatient(hm.firstPatientInList)) {
            // if is false (he's at the beginning or not in the list)
            hm.firstPatientInList = hm.firstPatientInList.getNextPatient(hm.firstPatientInList);
        }

        hm.firstPatientInList.prettyPrintAll();
    }
}

