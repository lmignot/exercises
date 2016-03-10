/**
 * YoungPatient class implementation with error-checking for Illegal age argument
 */
public class YoungPatient {

    private int age;
    private String name;
    private String illness;

    /**
     * YoungPatient constructor
     * @param name The YoungPatient's name
     * @param age The YoungPatient's age
     * @param illness The YoungPatient's illness
     *
     * @throws IllegalArgumentException if the age is negative or greater than 130
     */
    public YoungPatient(String name, int age, String illness) {
        if (age < 0 || age > 130) {
            throw new IllegalArgumentException("Invalid age entered for this patient!");
        }

        this.name = name;
        this.illness = illness;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getIllness() {
        return illness;
    }
}
