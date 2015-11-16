public class Person {
    private String name;
    private int age;
    private Person next;
    private Person prev;


    /**
     * Empty constructor
     * @return empty Person
     */
    public Person () {}

    /**
     * A Person class to use in a dynamic data structure
     * @param  name The name of this person
     * @param  age  Their age
     */
    public Person (String name, int age) {
        this.name = name;
        this.age = age;
        this.next = null;
        this.prev = null;
    }

    /**
     * Returns the Person's name
     * @return String
     */
    public String getName () {
        return this.name;
    }

    /**
     * Returns the Person's age
     * @return int
     */
    public int getAge () {
        return this.age;
    }

    /**
     * Get the next Person in the linked list
     * @return Person
     */
    public Person getNext () {
        return this.next;
    }

    /**
     * Get the previous Person in the linked list
     * @return Person
     */
    public Person getPrev () {
        return this.prev;
    }

    /**
     * Set a pointer to the previous person in the list
     * @return Person
     */
    public void setPrev (Person person) {
        this.prev = person;
    }

    /**
     * Sets a pointer to the next Person in the list
     * @param person
     */
    public void setNext (Person person) {
        this.next = person;
    }
}
