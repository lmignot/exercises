public interface PersonQueue {
    /**
     * Adds another Person to the queue
     */
    void insert (Person person);

    /**
     * Removes a Person from the queue
     */
    Person retrieve ();
}
