/**
 * Implementation of a List as a LinkedList
 *
 * @author Laurent Mignot
 */
package DataStructures;
import java.util.EmptyStackException;

public class LinkedList<T extends Comparable<? super T>> implements List<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public LinkedList () {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    /**
     * @see List#isEmpty()
     */
    @Override
    public boolean isEmpty () {
        return this.size == 0;
    }

    /**
     * @see List#size()
     */
    @Override
    public int size () {
        return this.size;
    }

    /**
     * @see List#get(int)
     */
    @Override
    public T get (int index)  {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        if (this.isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

        T result;

        if (index == 0) {
            result = this.head.getValue();
        } else if (index == (this.size - 1)) {
            result = this.tail.getValue();
        } else {
            result = this.getNodeAtIndex(index).getValue();
        }

        return result;
    }

    /**
     * I've chosen to not check for isEmpty in this scenario as
     * the isOutOfBounds check would return true for an empty structure
     * empty size: (0 - 1 = -1 = < 0)
     * @see List#remove(int)
     */
    @Override
    public T remove (int index) {
        if (this.isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> toRemove;

        if (index == 0) {
            toRemove = this.head;
            this.head = toRemove.getNext();
        } else if (index == (this.size - 1)) {
            toRemove = this.tail;
            this.tail = toRemove.getPrev();
        } else {
            toRemove = this.getNodeAtIndex(index);
        }

        Node<T> before = toRemove.getPrev();
        Node<T> after = toRemove.getNext();

        if (before != null) { before.setNext(after); }
        if (after != null) { after.setPrev(before); }

        this.size--;

        return toRemove.getValue();
    }

    /**
     * @see List#add(int, T)
     */
    @Override
    public void add (int index, T item) {
        if (this.isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node<T> newNode = new Node<>(item);

        if (index == 0) {
            Node<T> first = this.head;
            this.head = newNode;
            this.head.setNext(first);
            first.setPrev(this.head);
        } else if (index == (this.size - 1)) {
            Node<T> last = this.tail;
            this.tail = newNode;
            this.tail.setPrev(last);
            last.setNext(this.tail);
        } else {
            Node<T> addAfter = this.getNodeAtIndex(index - 1);
            newNode.setNext(addAfter.getNext());
            addAfter.getNext().setPrev(newNode);
            addAfter.setNext(newNode);
            newNode.setPrev(addAfter);
        }

        this.size++;
    }

    /**
     * @see List#add(T)
     */
    @Override
    public void add (T item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (this.head == null) {
            this.head = new Node<>(item);
            this.tail = this.head;
        } else {
            Node<T> last = this.tail;
            this.tail = new Node<>(item);
            this.tail.setPrev(last);
            last.setNext(this.tail);
        }

        this.size++;
    }

    /**
     * Retrieves a Node in the list at the given index
     * @param index
     * @return the Node at the given index, or an empty
     * Node if given index is out of bounds
     */
    protected Node<T> getNodeAtIndex (int index) {
        if (this.isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

        int currentIndex = 0;
        Node<T> current;

        if (index > Math.abs((this.size - 1) / 2)) {
            current = this.tail;
            currentIndex = this.size - 1;
            while (current.getPrev() != null) {
                if (currentIndex == index) { break; }
                current = current.getPrev();
                currentIndex--;
            }
        } else {
            current = this.head;
            while (current.getNext() != null) {
                if (currentIndex == index) { break; }
                current = current.getNext();
                currentIndex++;
            }
        }
        return current;
    }

    /**
     * Check whether the given index is out of bounds of the data structure
     * @param index the index to check
     * @return true if out of bounds, false otherwise
     */
    protected boolean isOutOfBounds (int index) {
        return (index < 0 || index > (this.size - 1));
    }
}