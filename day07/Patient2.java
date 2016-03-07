public class Patient2 {
    private String name;
    private int age;
    private String illness;

    private Patient2 nextPatient;
    private Patient2 prevPatient;

    public Patient2(String name, int age, String illness) {
        this.name = name;
        this.age = age;
        this.illness = illness;
        this.nextPatient = null;
        this.prevPatient = null;
    }

    public void prettyPrint () {
        System.out.print("My name is " + this.name + ", I am " + this.age + " years old,");
        System.out.println(" and i have " + this.illness);
    }

    public String toString () {
        return "Name: " + this.name + ", age: " + this.age + ", illness: " + this.illness;
    }

    public String getName () {
        return this.name;
    }

    public String getIllness () {
        return this.illness;
    }

    public int getAge () {
        return this.age;
    }

    public Patient2 getPrevPatient () {
        return this.prevPatient;
    }

    public Patient2 getNextPatient () {
        return this.nextPatient;
    }

    public void setNextPatient (Patient2 patient) {
        this.nextPatient = patient;
    }

    public void setPrevPatient (Patient2 patient) {
        this.prevPatient = patient;
    }
}
