/**
 * A Stack Implementation
 *
 * @author Laurent Mignot
 */
package DataStructures;
import java.util.EmptyStackException;

public class StackImpl<T extends Number> extends AbstractStack<T> {

    public StackImpl (GenericList<T> list) {
        super(list);
    }

    /**
     * @see Stack#isEmpty()
     */
    public boolean isEmpty () {
        return this.internalList == null || this.internalList.isEmpty();
    }

    /**
     * @see Stack#size()
     */
    public int size () {
        return this.internalList != null ? this.internalList.size() : 0;
    }

    /**
     * @see Stack#push(Object)
     */
    public void push (T item) {
        if (this.internalList != null && item != null) {
            this.internalList.add(item);
        }
    }

    /**
     * @see Stack#top()
     */
    public T top () {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        return this.internalList.get(this.size() - 1);
    }

    /**
     * @see Stack#pop()
     */
    public T pop () {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        return this.internalList.remove(this.size() - 1);
    }
}