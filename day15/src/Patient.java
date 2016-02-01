/**
 * Patient class implementation with error-checking for Illegal age argument
 */
public class Patient {

    private int age;
    private String name;
    private String illness;

    /**
     * Patient constructor
     * @param name The Patient's name
     * @param age The Patient's age
     * @param illness The Patient's illness
     *
     * @throws IllegalArgumentException if the age is negative or greater than 130
     */
    public Patient (String name, int age, String illness) {
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
