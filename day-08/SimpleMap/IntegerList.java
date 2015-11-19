/**
 * Linked list using integers as ids
 * for use in an int/String map
 */
public class IntegerList {

    private int size = 0;
    private MapNode head = null;

    public IntegerList () {}

    /**
     * Adds a node to the list if a node with the same key does not exist
     * @param node The node to add
     */
    public void add (MapNode node) {
        boolean didAdd = true;
        if (this.head == null) {
            this.head = node;
        } else {
            MapNode current = this.head;
            boolean keyExists = false;
            while (current.getNext() != null) {
                if (current.getKey() == node.getKey()) {
                    keyExists = true;
                    break;
                }
                current = current.getNext();
            }
            if (!keyExists) {
                current.setNext(node);
                node.setPrev(current);
                didAdd = true;
            }
        }
        if (didAdd) { this.size++; }
    }

    /**
     * Removes a node from the list
     * @param node The node to delete
     */
    public boolean delete (MapNode node) {

        // always handle empty list scenario
        if (this.size == 0) { return false; }

        // if it's the first node in the list
        // we need to update head
        if (this.head.getKey() == node.getKey()) {
            this.head = this.head.getNext();
            this.head.setPrev(null);
        } else {
            node.getNext().setPrev(node.getPrev());
            node.getPrev().setNext(node.getNext());
        }

        this.size--;
        return true;
    }

    /**
     * Retrieves a node in the list
     * @param id The key matching the node to retrieve
     * @return MapNode || null
     */
    public MapNode find (int id) {
        if (this.size == 0) {
            return null;
        } else if (this.head.getKey() == id) {
            return this.head;
        } else {
            MapNode current = this.head;
            MapNode found = null;
            while (current.getNext() != null) {
                current = current.getNext();
                // break early if we have found the
                // node we want
                if (current.getKey() == id) {
                    found = current;
                    break;
                }
            }
            return found;
        }
    }

    /**
     * Prints all nodes in the list to the console
     */
    public void prettyPrint () {
        if (this.size == 0) {
            System.out.println("Empty List");
        } else {
            MapNode current = this.head;
            System.out.println(current.toString());
            while (current.getNext() != null) {
                current = current.getNext();
                System.out.println(current.toString());
            }
        }
    }

    /**
     * Retrieves the number of nodes in the list
     */
    public int getSize () {
        return this.size;
    }
}
