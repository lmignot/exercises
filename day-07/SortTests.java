public class SortTests {

    public static void main(String[] args) {
        ListUtilities utils = new ListUtilities();

        IntegerList intList = utils.arrayToIntegerList(new int[] {56,3,1,5,6,8,2,98,23,7,4,98,21,93,84,17,109}, false);

        System.out.println("Unsorted integer list initialised, size is: " + intList.getSize());
        System.out.println("");
        intList.prettyPrint();

        System.out.println("");
        System.out.print("Bubble sorting list...");
        IntegerList intListSorted = utils.bubbleSort(intList);
        System.out.println("done");

        System.out.println("");
        intListSorted.prettyPrint();

    }

}
