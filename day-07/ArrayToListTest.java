public class ArrayToListTest {

    public static void main(String[] args) {
        ListUtilities utils = new ListUtilities();

        IntegerList intList = utils.arrayToIntegerList(new int[] {1,5,6,8,2,98,23,7,4,98,21,93,84,17,109}, false);

        System.out.println("Integer list initialised, size is: " + intList.getSize());
        System.out.println("");
        intList.prettyPrint();

        IntegerList intListSorted = utils.arrayToIntegerList(new int[] {8,1,5,6,8,2,98,23,7,4,98,21,93,84,17,7,109}, true);

        System.out.println("");
        System.out.println("Sorted Integer list initialised, size is: " + intListSorted.getSize());
        System.out.println("");
        intListSorted.prettyPrint();

    }

}
