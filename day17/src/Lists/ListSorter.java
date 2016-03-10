package Lists;

import java.util.Objects;

/**
 * A ListSorter
 * This class is designed to run on a separate thread
 * monitor a given list's sorted status and sort it
 * when possible - ie. when no other operations are
 * in-progress.
 *
 * @author lmignot
 */
public class ListSorter implements Runnable {

    private ListStatus isSorted = ListStatus.UNSORTED;
    private SelfSortedList listToSort;

    /**
     * Constructor requires a list to sort
     * @param list The list to sort
     * @throws NullPointerException if the list is null
     */
    public ListSorter(SelfSortedList list) {
        Objects.requireNonNull(list);
        listToSort = list;
    }

    /**
     * Update the status of the Sorter and notify any
     * threads that are waiting
     *
     * @param status
     */
    public synchronized void setStatus(ListStatus status) {
        isSorted = status;
        notifyAll();
    }

    /**
     * Runs the sorter. Check if the List is RUNNING<br>
     * If it is, check if the status is UNSORTED<br>
     * If UNSORTED, do some sorting
     */
    @Override
    public synchronized void run() {
        while (isSorted == ListStatus.UNSORTED ||
                listToSort.getStatus() == ListStatus.RUNNING) {
            // The list is sorted so wait until notified...
            while (isSorted == ListStatus.SORTED) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    // nada
                }
            }
            // tell the list to sort and
            // check if it finished sorting
            ListStatus listIsSorted = listToSort.sort();
            if (listIsSorted == ListStatus.SORTED) {
                isSorted = ListStatus.SORTED;
            }
        }
    }

    /**
     * If the status is UNSORTED, wait around until it is.<br>
     * If it's SORTED then tell the list to return the value
     *
     * @param index The index of the Integer to retrieve
     * @return the value at the given index
     */
    public synchronized int get(int index) {
        while(isSorted != ListStatus.SORTED) {
            try {
                wait();
            } catch (InterruptedException ex) {
                // nothing to see here... move along
            }
        }
        // ummm... tell the list to get something
    }
}
