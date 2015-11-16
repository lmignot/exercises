public class IntegerStack {
    private IntegerNode first = null;
    // reference to size
    private int s = 0;

    public IntegerStack () {}

    public void push (int val) {
        IntegerNode intNode = new IntegerNode(val);
        intNode.setNext(this.first);
        this.first = intNode;
        this.s++;
    }

    public int pop () {
        if (this.s == 0) {
            return 0;
        }

        IntegerNode newFirst = this.first.getNext();
        int result = this.first.getValue();
        this.first = newFirst;
        this.s--;
        return result;
    }

    public boolean empty () {
        return this.s == 0;
    }
}
