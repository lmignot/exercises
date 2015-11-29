public class IntegerTreeNode {
    int value;
    IntegerTreeNode left;
    IntegerTreeNode right;

    public IntegerTreeNode (int n) {
        this.value = n;
        this.left = null;
        this.right = null;
    }

    public int getValue () {
        return this.value;
    }

    public IntegerTreeNode getLeft () {
        return this.left;
    }

    public IntegerTreeNode getRight () {
        return this.right;
    }

    public void setLeft (IntegerTreeNode node) {
        this.left = node;
    }

    public void setRight (IntegerTreeNode node) {
        this.right = node;
    }

    public void add (int newNumber) {
        if (newNumber > this.value) {
            if (this.right == null) {
                this.right = new IntegerTreeNode(newNumber);
            } else {
                this.right.add(newNumber);
            }
        } else {
            if (this.left == null) {
                this.left = new IntegerTreeNode(newNumber);
            } else {
                this.left.add(newNumber);
            }
        }
    }

    public boolean remove (int n, IntegerTreeNode parent) {
        boolean result = true;

        if (this.value > n) {
            result = (this.left != null) ? this.left.remove(n, this) : false;
        } else if (this.value < n) {
            result = (this.right != null) ? this.right.remove(n, this) : false;
        } else {
            if (this.left != null && this.right != null) {
                // swap the minimum on the right for this value
                // and then remove that value from the right
                this.value = this.right.getMin();
                this.right.remove(this.value, this);
            } else if (parent.left == this) {
                parent.left = (this.left != null) ? this.left : this.right;
            } else if (parent.right == this) {
                parent.right = (this.left != null) ? this.left : this.right;
            }
            result = true;
        }
        return result;
    }

    public boolean contains (int n) {
        if (n == this.value) {
            return true;
        } else if (n > this.value) {
            if (this.right == null) {
                return false;
            } else {
                return this.right.contains(n);
            }
        } else {
            if (this.left == null) {
                return false;
            } else {
                return this.left.contains(n);
            }
        }
    }

    public int getMax () {
        if (this.right == null) {
            return this.value;
        } else {
            return this.right.getMax();
        }
    }

    public int getMin () {
        if (this.left == null) {
            return this.value;
        } else {
            return this.left.getMin();
        }
    }

    public String toString(){
        String result = "[" + this.value;
        result += this.left == null ? " L[]" : " L[" + this.left.toString() + "]";
        result += this.right == null ? " R[]" : " R[" + this.right.toString()  + "]";
        result += "]";

        return result;
    }

    public int depth () {
        int result = 0;
        int resultLeft = 0;
        int resultRight = 0;

        if (this.left != null) {
            resultLeft += 1 + this.left.depth();
        }
        if (this.right != null) {
            resultRight += 1 + this.right.depth();
        }

        if (resultLeft == 0 && resultRight == 0) {
            return result;
        } else {
            return (resultLeft > resultRight) ? resultLeft : resultRight;
        }
    }
}
