public class Patient3 {
    private int id;
    private String name;
    private int age;
    private String illness;

    private Patient3 nextPatient;

    public Patient3(int id, String name, int age, String illness) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.illness = illness;
        this.nextPatient = null;
    }

    public void prettyPrint () {
        System.out.print("My name is " + this.name + ", I am " + this.age + " years old,");
        System.out.println(" and i have " + this.illness);
    }

    public String toString () {
        return "Id: " + this.id + ", name: " + this.name + ", age: " + this.age + ", illness: " + this.illness;
    }

    public int getId () {
        return this.id;
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

    public Patient3 getNextPatient () {
        return this.nextPatient;
    }

    public void setNextPatient (Patient3 patient) {
        this.nextPatient = patient;
    }

}
