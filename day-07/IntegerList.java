public class IntegerList {

    private int size = 0;
    private IntegerNode start;
    private boolean autoSort = false;

    public IntegerList (boolean sort) {
        // conrol whether or not we autosort this list
        this.autoSort = sort;
    }

    // @TODO: implement sorting
    // not sure if we do it while adding or have another private method
    // that sorts it after it's been added..
    // seems like the list would already be sorted
    // so might as well shove it inbetween the next smallest and larger integers
    // i wonder about duplicates???
    public void add (IntegerNode intNode) {
        if (this.start == null) {
            this.start = intNode;
        } else {
            IntegerNode current = this.start;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(intNode);
        }
        this.size++;
    }

    public boolean delete (IntegerNode intNode) {
        if (this.size == 0) {
            return false;
        }

        boolean didDelete = false;

        if (this.start.getValue() == intNode.getValue()) {
            this.start = this.start.getNext();
            didDelete = true;
        } else {
            IntegerNode current = this.start;
            IntegerNode prev = this.start;
            boolean shouldDelete = false;
            // the boolean is not strictly necessary
            // but it avoids us continuing the loop
            // if we've located the item to delete
            // before the end of the list
            while (current.getNext() != null) {
                prev = current;
                current = current.getNext();
                if (current.getValue() == intNode.getValue()) {
                    shouldDelete = true;
                    break;
                }
            }
            if (shouldDelete) {
                prev.setNext(current.getNext());
                didDelete = true;
            }
        }

        // decrement the size if we did delete a node
        if (didDelete) {
            this.size--;
        }
        return didDelete;
    }

    public void prettyPrint () {
        if (this.size == 0) {
            System.out.println("Empty IntegerList");
        } else {
            IntegerNode current = this.start;
            System.out.println(current.toString());
            while (current.getNext() != null) {
                current = current.getNext();
                System.out.println(current.toString());
            }
        }
    }

    public int getSize () {
        return this.size;
    }
}
