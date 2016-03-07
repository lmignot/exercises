package Supermarket;

public class ArrayPersonQueue implements PersonQueue {
    private Person[] queue;
    private int size;

    public ArrayPersonQueue () {
        this.size = 0;
        this.queue = new Person[4];
    }

    public void insert (Person person) {
        this.size++;

        // increase queue size if necessary
        if (this.queue.length < this.size) {
            this.increaseSize();
        }

        Person prev = person;
        for (int i = 0; i < this.size; i++) {
            Person next = this.queue[i];
            this.queue[i] = prev;
            prev = next;
        }
    }

    public int getSize () {
        return this.size;
    }

    public Person retrieve () {
        Person result = null;

        if (this.size > 0) {
            result = this.queue[this.size - 1];
            this.size--;
        }

        if ((this.queue.length / 2) > this.size) {
            this.decreaseSize();
        }

        return result;
    }

    public void prettyPrint () {
        if (this.size == 0) {
            System.out.println("Empty queue...");
        } else {
            System.out.println("Queue size: " + this.getSize());
            for (int i = 0; i < this.size; i++) {
                Person current = this.queue[i];
                System.out.println("Name: " + current.getName() + ", age: " + current.getAge());
            }
        }
    }

    private void increaseSize () {
        int oldSize = this.queue.length;
        int newSize = oldSize * 2;
        Person[] tmp = new Person[newSize];

        for (int i = 0; i < oldSize; i++) {
            tmp[i] = this.queue[i];
        }
        this.queue = tmp;
    }

    private void decreaseSize () {
        int oldSize = this.queue.length;
        int newSize = oldSize / 2;
        Person[] tmp = new Person[newSize];

        for (int i = 0; i < newSize; i++) {
            tmp[i] = this.queue[i];
        }
        this.queue = tmp;
    }
}
