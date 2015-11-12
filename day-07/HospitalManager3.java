public class HospitalManager3 {
    private PatientListCircular patients = null;

    public static void main(String[] args) {

        HospitalManager3 hm = new HospitalManager3();

        hm.patients = new PatientListCircular();

        hm.patients.add(new Patient3(hm.patients.getSize() + 1, "Dave", 32, "Hives"));
        hm.patients.add(new Patient3(hm.patients.getSize() + 1, "Jane", 48, "Arrythmia"));
        hm.patients.add(new Patient3(hm.patients.getSize() + 1, "Jack", 22, "Agoraphobia"));
        hm.patients.add(new Patient3(hm.patients.getSize() + 1, "Bill", 99, "Age"));
        hm.patients.add(new Patient3(hm.patients.getSize() + 1, "Dick", 44, "Warts"));
        hm.patients.add(new Patient3(hm.patients.getSize() + 1, "Samantha", 21, "Clamydia"));
        hm.patients.add(new Patient3(hm.patients.getSize() + 1, "Peter", 39, "Arthritis"));
        hm.patients.add(new Patient3(hm.patients.getSize() + 1, "Joy", 57, "Cancer"));
        hm.patients.add(new Patient3(hm.patients.getSize() + 1, "Ronald", 27, "Herpes"));
        hm.patients.add(new Patient3(hm.patients.getSize() + 1, "Tom", 87, "Cataracts"));
        hm.patients.add(new Patient3(hm.patients.getSize() + 1, "Pearl", 22, "Migraines"));
        hm.patients.add(new Patient3(hm.patients.getSize() + 1, "Tamara", 26, "Flu"));

        System.out.println("Total number of patients: " + hm.patients.getSize());
        System.out.println("");
        hm.patients.prettyPrintForward();
        System.out.println("");

        if (hm.patients.delete(1)) {
            System.out.println("Deleted patient id 1");
        } else {
            System.out.println("Unable to delete patient id 1");
        }
        if (hm.patients.delete(5)) {
            System.out.println("Deleted patient id 5");
        } else {
            System.out.println("Unable to delete patient id 5");
        }
        if (hm.patients.delete(13)) {
            System.out.println("Deleted patient id 13");
        } else {
            System.out.println("Unable to delete patient id 13");
        }

        System.out.println("");
        System.out.println("Total number of patients: " + hm.patients.getSize());
        System.out.println("");
        hm.patients.prettyPrintForward();
        System.out.println("");

    }
}

