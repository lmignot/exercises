package trees;

public class TreeTests {

    public static void main (String[] args) {
        IntegerTreeNode start = new IntegerTreeNode(9);

        start.add(13);
        start.add(6);
        start.add(7);
        start.add(8);
        start.add(5);
        start.add(22);
        start.add(3);
        start.add(1);


        System.out.println("getMax() should return 22... " + start.getMax());
        System.out.println("getMin() should return 1... " + start.getMin());
        System.out.println(start.toString());

        System.out.print("depth() should correctly calculate depth of tree... ");
        System.out.println(((start.depth() == 4) ? "passed" : "failed"));

        System.out.println("**********************");
        System.out.println("Testing Binary Tree");
        System.out.println("Added to handle remove() - have to keep track of root node");
        System.out.println("**********************");

        BinaryTree tree = new BinaryTree(new IntegerTreeNode(9));

        tree.add(13);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(5);
        tree.add(22);
        tree.add(3);
        tree.add(1);

        System.out.println("getMax() should return 22... " + tree.getMax());
        System.out.println("getMin() should return 1... " + tree.getMin());
        System.out.println(tree.toString());

        System.out.print("depth() should correctly calculate depth of tree... ");
        System.out.println(((tree.depth() == 4) ? "passed" : "failed"));

        System.out.print("remove() should delete the correct element from the tree...");
        System.out.println(tree.remove(5) ? "passed" : "failed");
        System.out.println(tree.toString());

        System.out.print("remove() value that is root should remove the value and not lose the tree...");
        System.out.println(tree.remove(9) ? "passed" : "failed");
        System.out.println(tree.toString());
    }
}
