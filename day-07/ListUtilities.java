public class ListUtilities {

    public IntegerList arrayToIntegerList (int[] ints, boolean sort) {
        IntegerList intList = new IntegerList(sort);

        for (int i = 0; i < ints.length; i++) {
            intList.add(new IntegerNode(ints[i]));
        }

        return intList;
    }

}
