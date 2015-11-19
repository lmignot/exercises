/**
 * Implementation of PersonQueue using a linked list
 */
public class PointerPersonQueue implements PersonQueue {

    private Person tail;
    private Person head;
    private int size;

    public PointerPersonQueue () {
        this.tail = null;
        this.head = null;
        this.size = 0;
    }

    public void insert (Person person) {
        if (this.tail == null) {
            // we have nothing in the queue
            this.tail = person;
            this.head = person;
        } else {
            this.tail.setPrev(person);
            // we need to shift the entire queue over by one
            person.setNext(this.tail);
            this.tail = person;
        }
        this.size++;
    }

    public Person retrieve () {
        if (this.size == 0) {
            // not sure what to do here, ideally should
            // throw an exception of sorts
            return new Person();
        } else {
            Person result = this.head;
            this.head = result.getPrev();
            this.head.setNext(null);
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
            Person current = this.tail;
            do {
                System.out.println("Name: " + current.getName() + ", age: " + current.getAge());
                current = current.getNext();
            } while (current.getNext() != null);
            System.out.println("Name: " + current.getName() + ", age: " + current.getAge());
        }
    }
}
