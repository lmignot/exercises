/**
 * Represents a Node in a LinkedList
 *
 * @author Laurent Mignot
 */
package DataStructures;
public class Node<T> {

    private T value;
    private Node<T> next;
    private Node<T> prev;

    public Node (T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public T getValue () {
        return this.value;
    }

    public Node<T> getNext () {
        return this.next;
    }

    public void setNext (Node<T> n) {
        this.next = n;
    }

    public Node<T> getPrev () {
        return this.prev;
    }

    public void setPrev (Node<T> p) {
        this.prev = p;
    }
}