public class SortTests {

    public static void main(String[] args) {

        IntegerList intList = ListUtilities.arrayToIntegerList(new int[] {56,3,1,5,6,8,2,98,23,7,4,98,21,93,84,17,109}, false);

        System.out.println("Unsorted integer list initialised.");
        intList.prettyPrint();

        System.out.println("");
        System.out.print("Bubble sorting list...");
        long start = System.currentTimeMillis();
        IntegerList intListSorted = ListUtilities.bubbleSort(intList);
        long duration = System.currentTimeMillis() - start;
        System.out.println("done. Sorted in " + duration + "ms");
        intListSorted.prettyPrint();
    }

}
