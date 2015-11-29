public class ClusteredQueue implements PersonQueue {
    private SortedQueue retireeQueue;
    private SortedQueue adultQueue;
    private SortedQueue childQueue;

    public ClusteredQueue () {
        this.retireeQueue = new SortedQueue();
        this.adultQueue = new SortedQueue();
        this.childQueue = new SortedQueue();
    }

    public void insert (Person person) {
        if (person.getAge() > 65) {
            this.retireeQueue.insert(person);
        } else if (person.getAge() > 18) {
            this.adultQueue.insert(person);
        } else {
            this.childQueue.insert(person);
        }
    }

    public int getSize () {
        return this.retireeQueue.getSize() + this.adultQueue.getSize() + this.childQueue.getSize();
    }

    public Person retrieve () {
        Person result = null;

        if (this.retireeQueue.getSize() > 0) {
            result = this.retireeQueue.retrieve();
        } else if (this.adultQueue.getSize() > 0) {
            result = this.adultQueue.retrieve();
        } else if (this.childQueue.getSize() > 0) {
            result = this.childQueue.retrieve();
        }

        return result;
    }

    public void prettyPrint () {
        if (this.retireeQueue.getSize() > 0) {
            this.retireeQueue.prettyPrint();
        }
        if (this.adultQueue.getSize() > 0) {
            this.adultQueue.prettyPrint();
        }
        if (this.childQueue.getSize() > 0) {
            this.childQueue.prettyPrint();
        }
    }
}
