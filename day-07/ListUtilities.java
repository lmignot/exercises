public class ListUtilities {

    public static IntegerList arrayToIntegerList (int[] ints, boolean sort) {
        IntegerList intList = new IntegerList(sort);

        for (int i = 0; i < ints.length; i++) {
            intList.add(new IntegerNode(ints[i]));
        }

        return intList;
    }

    public static IntegerList bubbleSort (IntegerList list) {
        int size = list.getSize();
        if (size == 0) {
            System.out.println("Empty list, nothing to sort.");
        } else if (size == 1) {
            System.out.println("Only one node in list, already sorted.");
        } else {
            IntegerNode current;

            // keep track of whether we did a swap in the inner loop
            // if we did not swap for a full iteration
            // we can stop the outer loop
            boolean didSwap = false;

            for (int i = 0; i < size; i++) {
                didSwap = false;
                for (int j = 0; j < size; j++) {
                    current = list.getAt(j);
                    if (current.getNext() != null &&
                        current.getValue() > current.getNext().getValue()) {
                        // System.out.println("**********");
                        // System.out.println("swapping: " + current.getValue() + " <> " + current.getNext().getValue());
                        // System.out.println("**********");
                        list.swap(current, current.getNext());
                        didSwap = true;
                    }
                    // list.prettyPrint();
                }
                if (!didSwap) {
                    break;
                }
            }
        }

        return list;
    }

    public static IntegerList cocktailSort(IntegerList list) {
        // TODO: implement bubbleSort
        return list;
    }

    public static IntegerList quickSort(IntegerList list) {
        // TODO: implement bubbleSort
        return list;
    }

}
