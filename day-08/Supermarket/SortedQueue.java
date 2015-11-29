public class SortedQueue implements PersonQueue {
    private Person tail;
    private Person head;
    private int size;

    public SortedQueue () {
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
            // handle new person being older than current oldest person
            if (this.head.getAge() < person.getAge()) {
                Person tmp = this.head;
                this.head = person;
                tmp.setNext(person);
                this.head.setPrev(tmp);
            } else if (this.tail.getAge() > person.getAge()) {
                // we need to shift the entire queue over by one
                this.tail.setPrev(person);
                person.setNext(this.tail);
                this.tail = person;
            } else {
                Person current = this.tail;
                while (current.getNext() != null) {
                    if (current.getAge() > person.getAge()) {
                        break;
                    }
                    current = current.getNext();
                }
                Person prev = current.getPrev();
                prev.setNext(person);
                person.setPrev(prev);
                person.setNext(current);
                current.setPrev(person);
            }
        }
        this.size++;
    }

    public Person retrieve () {
        if (this.size == 0) {
            return null;
        } else {
            Person result = this.head;
            if (this.head != this.tail) {
                this.head = result.getPrev();
                this.head.setNext(null);
            } else {
                // head == tail so
                // we reset them both to null
                this.head = null;
                this.tail = null;
            }
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
            // System.out.println(this.getSize() + " people left in the queue.");
            Person current = this.tail;
            do {
                System.out.println("Name: " + current.getName() + ", age: " + current.getAge());
                current = current.getNext();
            } while (current.getNext() != null);
            System.out.println("Name: " + current.getName() + ", age: " + current.getAge());
        }
    }
}
