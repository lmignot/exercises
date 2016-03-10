import Lists.ListStatus;
import Lists.SelfSortedList;

/**
 * @author lmignot
 */
public class ListTest {

    public static void main(String... args) {
        ListTest tester = new ListTest();
        tester.runTest();
    }

    private void runTest() {
        SelfSortedList list = new SelfSortedList();

        list.add(109);
        list.add(22);
        list.add(30);
        list.add(40);
        System.out.println("Index 1: " + list.get(1));
        list.add(87);
        list.add(145);
        list.prettyPrint();
        list.add(10);
        System.out.println("Index 3: " + list.get(3));
        list.add(20);
        list.add(92);
        list.add(89);
        list.add(22);
        list.prettyPrint();
        list.add(45);
        System.out.println("Index 2: " + list.get(2));
        list.add(98);
        list.add(56);
        list.add(12);

        list.prettyPrint();

        System.out.println("Index 0: " + list.get(0));
        System.out.println("Index 5: " + list.get(5));
        System.out.println("Index 8: " + list.get(8));
        System.out.println("Index 10: " + list.get(10));
        System.out.println("Index 13: " + list.get(13));

        list.setStatus(ListStatus.STOPPED);
    }
}
