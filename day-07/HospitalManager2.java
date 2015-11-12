public class HospitalManager2 {
    private PatientList patients = null;

    public static void main(String[] args) {

        HospitalManager2 hm = new HospitalManager2();

        hm.patients = new PatientList();

        hm.patients.add(new Patient2("Dave", 32, "Hives"));
        hm.patients.add(new Patient2("Jane", 48, "Arrythmia"));
        hm.patients.add(new Patient2("Jack", 22, "Agoraphobia"));
        hm.patients.add(new Patient2("Bill", 99, "Age"));
        hm.patients.add(new Patient2("Dick", 44, "Warts"));
        hm.patients.add(new Patient2("Samantha", 21, "Clamydia"));
        hm.patients.add(new Patient2("Peter", 39, "Arthritis"));
        hm.patients.add(new Patient2("Joy", 57, "Cancer"));
        hm.patients.add(new Patient2("Ronald", 27, "Herpes"));
        hm.patients.add(new Patient2("Tom", 87, "Cataracts"));
        hm.patients.add(new Patient2("Pearl", 22, "Migraines"));
        hm.patients.add(new Patient2("Tamara", 26, "Flu"));

        System.out.println("Total number of patients: " + hm.patients.getSize());
        System.out.println("");
        hm.patients.prettyPrintForward();
        System.out.println("");
        hm.patients.prettyPrintReverse();
        System.out.println("");

        if (hm.patients.delete("Dave")) {
            System.out.println("Deleted Dave");
        } else {
            System.out.println("unable to delete Dave");
        }
        if (hm.patients.delete("Tom")) {
            System.out.println("Deleted Tom");
        } else {
            System.out.println("unable to delete Tom");
        }
        if (hm.patients.delete("Jamie")) {
            System.out.println("Deleted Jamie");
        } else {
            System.out.println("unable to delete Jamie");
        }

        System.out.println("");
        System.out.println("Total number of patients: " + hm.patients.getSize());
        System.out.println("");
        hm.patients.prettyPrintForward();
        System.out.println("");
        hm.patients.prettyPrintReverse();
        System.out.println("");

    }
}

