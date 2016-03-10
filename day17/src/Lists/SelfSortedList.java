package Lists;

/**
 * PiJ day 18 - exercise 7.1a<br>
 * A Self-sorting Integer list<br>
 *
 * <p>Spec from exercise as interpreted by me:</p>
 * <ul>
 *     <li>List class and Sorter class</li>
 *     <li>Sorter should be on a separate thread</li>
 *     <li>{@code add} sets Sorter status to UNSORTED</li>
 *     <li>{@code get} triggers a sort &ndash; delegate to Sorter</li>
 *     <li>Sorter should sort small chunks at a time</li>
 *     <li>{@code get} blocks any further calls until it returns</li>
 * </ul>
 *
 * @author lmignot
 */
public class SelfSortedList {

    private ListSorter listSorter;
    private Node head;
    private ListStatus status;
    private int size = 0;

    public SelfSortedList() {
        head = new Node();
        status = ListStatus.RUNNING;
        listSorter = new ListSorter(this);
        Thread t = new Thread(listSorter);
        t.start();
    }

    public void add(Integer value) {
        Node n = new Node(value);
        Node current = head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(n);
        listSorter.setStatus(ListStatus.UNSORTED);
        size++;
    }

    /**
     * Delegates to Sorter so we can check if the list is unsorted
     * and if not, the sorter will sort the list
     *
     * @param index The index of the requested value
     * @return The value at the given index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public Integer get(int index) {
        if (index < 0 || index > (size - 1)) {
            throw new IndexOutOfBoundsException();
        }
        return listSorter.get(index);
    }

    /**
     * Once sorter has determined that the list is sorted
     * it will call this method... I think. Need to test
     *
     * @param index The index of the requested value
     * @return The value at the given index or -1 if not available
     */
    public Integer getAt(int index) {
        Node current = head;
        int i = 0;
        if (index < 0 || index > (size - 1)) {
            return -1;
        }
        while(current.getNext() != null) {
            if (i == index) {
                return current.getValue();
            }
            current = current.getNext();
            i++;
        }
        return -1;
    }

    public ListStatus sort() {
        return ListStatus.UNSORTED;
    }

    public ListStatus getStatus() {
        return status;
    }

    public void setStatus(ListStatus status) {
        this.status = status;
    }
}

class Node {
    private Integer value;
    private Node next;

    public Node() {
        next = null;
    }

    public Node(int n) {
        this();
        value = n;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(int val) {
        value = val;
    }
}