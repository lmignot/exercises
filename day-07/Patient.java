public class Patient {
    private String name;
    private int age;
    private String illness;
    private Patient nextPatient;

    public Patient (String name, int age, String illness) {
        this.name = name;
        this.age = age;
        this.illness = illness;
        this.nextPatient = null;
    }

    public void addPatient (Patient newPatient) {
        if (this.nextPatient == null) {
            // this is the last patient in the list
            this.nextPatient = newPatient;
        } else {
            this.nextPatient.addPatient(newPatient);
        }
    }

    public Patient getNextPatient (Patient patient) {
        return this.nextPatient;
    }

    public boolean deletePatient (Patient patient) {
        // if there's no next patient, we can't delete
        if (this.nextPatient == null) {
            System.out.println(this.name + ": asked to delete " + patient.name + ", but " + this.name + "'s nextPatient is " + this.nextPatient);
            return false;
        } else if (this.nextPatient.name.equals(patient.name)) {
            // this patient's 'nextPatient' is the one to delete
            // so assign nextPatient to the next one after in the list
            System.out.println(this.name + ": asked to delete " + patient.name + " and it's worked");
            this.nextPatient = nextPatient.nextPatient;
            System.out.println(this.name + "'s nextPatient is now " + this.nextPatient.name);
            return true;
        } else {
            // nothing found so hand over deletion to the next patient
            System.out.println(this.name + ": asked to delete " + patient.name + ", nothing found so handed over to " + this.nextPatient.name);
            return this.nextPatient.deletePatient(patient);
        }
    }

    public void prettyPrintAll () {
        System.out.print("My name is " + this.name + ", I am " + this.age + " years old,");
        System.out.println(" and i have " + this.illness);
        if (this.nextPatient != null) {
            this.nextPatient.prettyPrintAll();
        }
    }
}
