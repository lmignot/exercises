public class SetTests {

    public static void main (String[] args) {
        System.out.println("*******************************");
        System.out.println("Testing Tree Set Implementation");
        System.out.println("*******************************");

        IntSetTree set = new IntSetTree(9);

        set.add(13);
        set.add(6);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(5);
        set.add(5);
        set.add(22);
        set.add(3);
        set.add(1);

        System.out.print("Testing contains...");
        System.out.println(set.contains(5) ? "passed." : "failed.");

        System.out.println("Testing contains verbose...");
        if (set.containsVerbose(1) && set.containsVerbose(22)) {
            System.out.println("Passed.");
        }

        System.out.println("Testing toString...");
        String test = set.toString();
        System.out.println(test);
        System.out.println(test.equals("9,6,5,3,1,7,8,13,22") ? "Passed." : "Failed.");

        System.out.println("");
        System.out.println("*******************************");
        System.out.println("Testing List Set Implementation");
        System.out.println("*******************************");

        IntSetList setList = new IntSetList();

        setList.add(9);
        setList.add(13);
        setList.add(6);
        setList.add(6);
        setList.add(7);
        setList.add(8);
        setList.add(5);
        setList.add(5);
        setList.add(22);
        setList.add(3);
        setList.add(1);

        System.out.print("Testing contains...");
        System.out.println(setList.contains(5) ? "passed." : "failed.");

        System.out.println("Testing contains Verbose...");
        if (setList.containsVerbose(7) && setList.containsVerbose(22)) {
            System.out.println("Passed.");
        }

        System.out.println("Testing toString...");
        String testList = setList.toString();
        System.out.println(testList);
        System.out.println(testList.equals("9,13,6,7,8,5,22,3,1") ? "Passed." : "Failed.");


    }
}
