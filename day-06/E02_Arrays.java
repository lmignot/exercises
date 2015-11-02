// E02 Arrays
//

public class E02_Arrays {

    public static void main (String[] args) {
        ArrayCopier arrayCopier = new ArrayCopier();

        System.out.println("Equal length test.");
        System.out.println("");

        int[] testSrc = {4, 2, 4, 8, 9, 5, 7, 2, 5};
        System.out.print("Source");
        arrayCopier.printArray(testSrc);

        int[] testDest = new int[9];
        System.out.print("Dest");
        arrayCopier.printArray(testDest);

        arrayCopier.copy(testSrc, testDest);

        System.out.print("After copy");
        arrayCopier.printArray(testDest);

        System.out.println("");
        System.out.println("Shorter source test.");
        System.out.println("");

        int[] test2Src = {4, 222, 4, 8098, 9, 5};
        System.out.print("Source");
        arrayCopier.printArray(test2Src);

        int[] test2Dest = {1, 2, 3, 4, 5, 7, 98, 3453, 2345, 211};
        System.out.print("Dest");
        arrayCopier.printArray(test2Dest);

        arrayCopier.copy(test2Src, test2Dest);

        System.out.print("After copy");
        arrayCopier.printArray(test2Dest);

        System.out.println("");
        System.out.println("Shorter destination test.");
        System.out.println("");

        int[] test3Src = {2, 3, 5, 7, 11, 13, 17, 19, 23};
        System.out.print("Source");
        arrayCopier.printArray(test3Src);

        int[] test3Dest = new int[5];
        System.out.print("Dest");
        arrayCopier.printArray(test3Dest);

        arrayCopier.copy(test3Src, test3Dest);

        System.out.print("After copy");
        arrayCopier.printArray(test3Dest);
    }

}
