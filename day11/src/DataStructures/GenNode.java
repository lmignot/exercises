/**
 * Represents a Node in a LinkedList
 *
 * @author Laurent Mignot
 */
package DataStructures;

public class GenNode<T> {

    private T value;
    private GenNode<T> next;
    private GenNode<T> prev;

    public GenNode(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public T getValue () {
        return this.value;
    }

    public GenNode<T> getNext () {
        return this.next;
    }

    public void setNext (GenNode<T> n) {
        this.next = n;
    }

    public GenNode<T> getPrev () {
        return this.prev;
    }

    public void setPrev (GenNode<T> p) {
        this.prev = p;
    }
}