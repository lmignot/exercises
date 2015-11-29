public class BinaryTree {
    private IntegerTreeNode root;

    public BinaryTree (IntegerTreeNode root) {
        this.root = root;
    }

    public IntegerTreeNode getRoot () {
        return this.root;
    }

    public void setRoot (IntegerTreeNode root) {
        this.root = root;
    }

    public void add (int n) {
        this.root.add(n);
    }

    public boolean remove (int n) {
        boolean result = false;
        if (this.root == null) {
            result = false;
        } else if (this.root.getValue() == n) {
            IntegerTreeNode tempRoot = new IntegerTreeNode(0);
            tempRoot.setLeft(this.root);
            result = this.root.remove(n, tempRoot);
            this.root = tempRoot.getLeft();
        } else {
            result = this.root.remove(n, null);
        }
        return result;
    }

    public int getMax () {
        return this.root.getMax();
    }

    public int getMin () {
        return this.root.getMin();
    }

    public int depth () {
        return this.root.depth();
    }

    public String toString () {
        return this.root.toString();
    }
}
