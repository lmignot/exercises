package lists;

public class TreeIntSortedList implements IntSortedList {
    int value;
    TreeIntSortedList left;
    TreeIntSortedList right;

    public TreeIntSortedList (int n) {
        this.value = n;
        this.left = null;
        this.right = null;
    }

    public void add (int newNumber) {
        if (newNumber > this.value) {
            if (this.right == null) {
                this.right = new TreeIntSortedList(newNumber);
            } else {
                this.right.add(newNumber);
            }
        } else {
            if (this.left == null) {
                this.left = new TreeIntSortedList(newNumber);
            } else {
                this.left.add(newNumber);
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

    public String toString(){
        String result = "[" + this.value;
        result += this.left == null ? " L[]" : " L[" + this.left.toString() + "]";
        result += this.right == null ? " R[]" : " R[" + this.right.toString()  + "]";
        result += "]";

        return result;
    }
}
