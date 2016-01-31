package DataStructures;

/**
 * A sorted list for PiJ exercises day 11
 */
public class SortedList<T extends Comparable<? super T>> extends LinkedList<T> {

    public SortedList () {
        super();
    }

    /**
     *
     */
    @Override
    public void add (T item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (this.isEmpty()) {
            super.add(item);
            return;
        }

        Node<T> current = this.getNodeAtIndex(0);

        if (item.compareTo(current.getValue()) < 0) {
            super.add(0, item);
            return;
        }

        // search through the list
        int curIndex = 0;

        while (current.getNext() != null) {
            current = current.getNext();
            curIndex++;

            // it's less than this item so exit early
            if (item.compareTo(current.getValue()) < 0) {
                break;
            }
        }

        if (item.compareTo(current.getValue()) < 0){
            curIndex--;
        } else if (item.compareTo(current.getValue()) > 0) {
            curIndex++;
        }

        // we can't add using index that is equal to the size of the list
        // so we do a simple add for that scenario
        System.out.println(curIndex);
        if (curIndex > super.size() - 1) {
            super.add(item);
        } else {
            super.add(curIndex, item);
        }
    }
}
