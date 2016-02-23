/**
 * Queue class from day 8
 * Included here to test for PiJ day 12 exercise 4.2
 */
public class Queue {
    // array for queue
    private int[] queue;
    // keep track of position for speedier retrieve operations
    // also use to determine if we need to increase array
    private int p;

    public Queue () {
        this.queue = new int[100];
        this.p = 0;
    }

    public void insert (int item) {
        p++;

        // increase queue size if necessary
        if (this.queue.length < p) {
            this._increaseQueue();
        }

        this._insert(item);
    }

    public int retrieve () {
        int result = 0;
        if (this.p > 0) {
            result = queue[p - 1];
            this.p--;
        }

        if ((this.queue.length / 2) > p) {
            this._decreaseQueue();
        }

        return result;
    }

    public int size () {
        return this.p;
    }

    public void printQueue () {
        System.out.print("[");
        for (int i = 0; i < this.p; i++) {
            System.out.print(this.queue[i] + ((i == this.p - 1) ? "" : "],["));
        }
        System.out.println("]");
    }

    private void _insert (int item) {
        int prev = item;
        for (int i = 0; i < p; i++) {
            int next = this.queue[i];
            this.queue[i] = prev;
            prev = next;
        }
    }

    private void _increaseQueue () {
        int oldSize = this.queue.length;
        int newSize = oldSize * 2;
        int[] tmp = new int[newSize];

        for (int i = 0; i < oldSize; i++) {
            tmp[i] = this.queue[i];
        }
        this.queue = tmp;
        // System.out.println("Increased queue size from " + oldSize + " to " + newSize);
    }

    private void _decreaseQueue () {
        int oldSize = this.queue.length;
        int newSize = oldSize / 2;
        int[] tmp = new int[newSize];

        for (int i = 0; i < newSize; i++) {
            tmp[i] = this.queue[i];
        }
        this.queue = tmp;
        // System.out.println("Decreased queue size from " + oldSize + " to " + newSize);
    }
}
