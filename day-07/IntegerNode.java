public class IntegerNode {
    private int value;
    private IntegerNode next;

    public IntegerNode (int val) {
        this.value = val;
        this.next = null;
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

    public String toString () {
        return Integer.toString(this.value);
    }

    private void setValue (int val) {
        this.value = val;
    }
}
