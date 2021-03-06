public class IntegerList {

    private int size = 0;
    private IntegerNode start;
    private boolean autoSort = false;

    public IntegerList (boolean sort) {
        // control whether or not we autosort this list
        this.autoSort = sort;
    }

    public IntegerNode getStart () {
        return this.start;
    }

    public IntegerNode getAt (int index) {
        IntegerNode current = this.start;
        for (int i = 0; i < this.size; i++) {
            if (i == index) {
                break;
            }
            current = current.getNext();
        }
        return current;
    }

    public void swap (IntegerNode nodeA, IntegerNode nodeB) {
        IntegerNode first = nodeA.getPrev();
        IntegerNode last = nodeB.getNext();

        nodeA.setNext(last);
        nodeA.setPrev(nodeB);
        nodeB.setNext(nodeA);
        nodeB.setPrev(first);

        if (first != null) {
            first.setNext(nodeB);
        } else {
            this.start = nodeB;
        }

        if (last != null) {
            last.setPrev(nodeA);
        }
    }

    public void add (IntegerNode intNode) {
        if (this.start == null) {
            this.start = intNode;
        } else {
            IntegerNode current = this.start;

            // case to handle new number being smaller than existing smallest number
            if (this.autoSort && current.getValue() >= intNode.getValue()) {
                this.start = intNode;
                intNode.setNext(current);
                current.setPrev(intNode);
            } else {
                while (current.getNext() != null) {
                    current = current.getNext();
                    if (this.autoSort) {
                        // break early if new value is less than existing value
                        if (current.getValue() >= intNode.getValue()) {
                            break;
                        }
                        // break early if new value is between 2 existing values
                        if (current.getValue() <= intNode.getValue() &&
                                current.getNext() != null &&
                                current.getNext().getValue() >= intNode.getValue()) {
                            break;
                        }
                    }
                }
                if (this.autoSort) {
                    IntegerNode next = current.getNext();
                    // it's smaller than current, so insert before
                    if (current.getValue() >= intNode.getValue()) {
                        current.getPrev().setNext(intNode);
                        intNode.setPrev(current.getPrev());
                        intNode.setNext(current);
                        current.setPrev(intNode);
                    } else if (current.getNext() == null) {
                        // we managed to get to the end of the list, insert it at the end
                        current.setNext(intNode);
                        intNode.setPrev(current);
                    } else {
                        // insert it between current and next
                        current.setNext(intNode);
                        intNode.setPrev(current);
                        intNode.setNext(next);
                        next.setPrev(intNode);
                    }
                } else {
                    current.setNext(intNode);
                    intNode.setPrev(current);
                }
            }
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
            this.start.setPrev(null);
            didDelete = true;
        } else {
            IntegerNode current = this.start;

            boolean shouldDelete = false;
            // the boolean is not strictly necessary
            // but it avoids us continuing the loop
            // if we've located the item to delete
            // before the end of the list
            while (current.getNext() != null) {
                current = current.getNext();
                if (current.getValue() == intNode.getValue()) {
                    shouldDelete = true;
                    break;
                }
            }
            if (shouldDelete) {
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
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
            System.out.print("[");
            while (current.getNext() != null) {
                System.out.print(current.toString() + ", ");
                current = current.getNext();
            }
            System.out.println(current.toString() + "]");
        }
    }

    public int getSize () {
        return this.size;
    }
}
