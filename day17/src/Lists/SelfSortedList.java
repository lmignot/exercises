package Lists;

import java.util.StringJoiner;

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

    private static final int SORT_INCREMENT = 5;

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
        Node current;
        int i = 0;
        if (index < 0 || index > (size - 1)) {
            return -1;
        }
        if (head.getNext() == null) {
            return -1;
        }
        current = head.getNext();
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
        Node current;
        // If there's only HEAD, it's sorted
        if (head.getNext() == null) {
            return ListStatus.SORTED;
        }
        current = head.getNext();
        int sortInc = 0;
        while (current.getNext() != null && sortInc < SORT_INCREMENT) {
            if (current.getValue() > current.getNext().getValue()) {
                int swap = current.getValue();
                current.setValue(current.getNext().getValue());
                current.getNext().setValue(swap);
                sortInc++;
            }
            current = current.getNext();
        }
        ListStatus check = ListStatus.SORTED;
        current = head.getNext();
        while (current.getNext() != null) {
            if (current.getValue() > current.getNext().getValue()) {
                check = ListStatus.UNSORTED;
            }
            current = current.getNext();
        }
        return check;
    }

    public ListStatus getStatus() {
        return status;
    }

    /**
     * Since this sorter is running a thread
     * &ndash; this allows us to tell it to stop.
     *
     * @param status Should be either ListStatus.RUNNING
     *               or ListStatus.STOPPED;
     * @throws IllegalArgumentException if the status is incorrect
     */
    public void setStatus(ListStatus status) {
        if (status != ListStatus.RUNNING && status != ListStatus.STOPPED) {
            throw new IllegalArgumentException();
        }
        this.status = status;
        listSorter.setStatus(ListStatus.UNSORTED);
    }

    /**
     * Prints the contents of the list
     */
    public void prettyPrint() {
        Node current;
        if (head.getNext() != null) {
            StringJoiner joiner = new StringJoiner(",","[","]");
            current = head.getNext();
            while(current.getNext() != null) {
                joiner.add(String.valueOf(current.getValue()));
                current = current.getNext();
            }
            System.out.println(joiner.toString());
        }
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