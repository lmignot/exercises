public class IntegerNode {
    private int value;
    private IntegerNode next;
    private IntegerNode prev;

    public IntegerNode (int val) {
        this.value = val;
        this.next = null;
        this.prev = null;
    }

    public int getValue () {
        return this.value;
    }

    public void setNext (IntegerNode intNode) {
        this.next = intNode;
    }

    public IntegerNode getNext () {
        return this.next;
    }

    public void setPrev (IntegerNode intNode) {
        this.prev = intNode;
    }

    public IntegerNode getPrev () {
        return this.prev;
    }

    public String toString () {
        return Integer.toString(this.value);
    }

    private void setValue (int val) {
        this.value = val;
    }
}
