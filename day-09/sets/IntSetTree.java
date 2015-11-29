public class IntSetTree implements IntSet {
    int value;
    IntSetTree left;
    IntSetTree right;

    public IntSetTree (int n) {
        this.value = n;
        this.left = null;
        this.right = null;
    }

    public void add (int n) {
        if (!this.contains(n)) {
            if (n > this.value) {
                if (this.right == null) {
                    this.right = new IntSetTree(n);
                } else {
                    this.right.add(n);
                }
            } else {
                if (this.left == null) {
                    this.left = new IntSetTree(n);
                } else {
                    this.left.add(n);
                }
            }
        }
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

    public boolean containsVerbose (int n) {
        System.out.println(this.value);
        if (n == this.value) {
            return true;
        } else if (n > this.value) {
            if (this.right == null) {
                return false;
            } else {
                return this.right.containsVerbose(n);
            }
        } else {
            if (this.left == null) {
                return false;
            } else {
                return this.left.containsVerbose(n);
            }
        }
    }

    public String toString () {
        String result = "" + this.value;
        if (this.left != null) {
            result += "," + this.left.toString();
        }
        if (this.right != null) {
            result += "," + this.right.toString();
        }
        return result;
    }

}
