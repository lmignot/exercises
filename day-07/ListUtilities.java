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
            IntegerNode current = list.getStart();

            // keep track of whether we did a swap in the inner loop
            // if we did not swap for a full iteration
            // we can stop the outer loop
            boolean didSwap = false;

            while (current.getNext() != null) {
                IntegerNode inner = list.getStart();
                didSwap = false;

                while (inner.getNext() != null) {
                    if (inner.getNext() != null &&
                        inner.getValue() > inner.getNext().getValue()) {
                        list.swap(inner, inner.getNext());
                        didSwap = true;
                    }
                    inner = inner.getNext();
                }

                current = current.getNext();
                if (!didSwap) {
                    break;
                }
            }
        }

        return list;
    }

    public static IntegerList cocktailSort (IntegerList list) {
        // TODO: implement cocktailSort
        return list;
    }

    public static IntegerList quickSort (IntegerList list) {
        // TODO: implement quickSort
        return list;
    }

}
