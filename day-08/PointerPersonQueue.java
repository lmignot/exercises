/**
 * Implementation of PersonQueue using a linked list
 */
public class PointerPersonQueue implements PersonQueue {

    private Person head;
    private Person tail;
    private int size;

    public PointerPersonQueue () {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insert (Person person) {
        if (this.head == null) {
            // we have nothing in the queue
            this.head = person;
            this.tail = person;
        } else {
            this.head.setPrev(person);
            // we need to shift the entire queue over by one
            person.setNext(this.head);
            this.head = person;
        }
        this.size++;
    }

    public Person retrieve () {
        if (this.size == 0) {
            return new Person();
        } else {
            Person result = this.tail;
            this.tail = result.getPrev();
            this.tail.setNext(null);
            this.size--;
            return result;
        }
    }

    public int getSize () {
        return this.size;
    }

    public void prettyPrint () {
        if (this.size == 0) {
            System.out.println("Empty queue...");
        } else {
            System.out.println("Queue size: " + this.getSize());
            Person current = this.head;
            do {
                System.out.println("Name: " + current.getName() + ", age: " + current.getAge());
                current = current.getNext();
            } while (current.getNext() != null);
            System.out.println("Name: " + current.getName() + ", age: " + current.getAge());
        }
    }
}
