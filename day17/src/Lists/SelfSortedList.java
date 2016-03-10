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
    }

    public Integer get(int index) {
        return listSorter.get(index);
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