// E04 Matrix One Liners

public class E04_Matrix_One_Liners {

    public static void main (String[] args) {
        Matrix matrix = new Matrix(3, 8);

        matrix.setMatrix("1,3,5,7,9,11,13,15;2,4,6,8,10,12,14,16;2,3,5,7,11,13,17,19");
        System.out.println("Test: initialise new Matrix(3, 8)");
        System.out.println("Test: matrix should accept valid values.");
        System.out.println("Call setMatrix(1,3,5,7,9,11,13,15;2,4,6,8,10,12,14,16;2,3,5,7,11,13,17,19)");
        matrix.prettyPrint();

        System.out.println("Test: matrix should not accept setMatrix() with invalid column values.");
        System.out.println("call setMatrix(2,4,6,8,10,12,14,16,0;1,3,5,7,9,11,13,15;2,3,5,7,11,13,17,19)");
        matrix.setMatrix("2,4,6,8,10,12,14,16,0;1,3,5,7,9,11,13,15;2,3,5,7,11,13,17,19");
        matrix.prettyPrint();

        System.out.println("Test: matrix should not accept setMatrix() with invalid row values.");
        System.out.println("call setMatrix(2,4,6,8,10,12,14,16;1,3,5,7,9,11,13,15;2,3,5,7,11,13,17,19;81,89)");
        matrix.setMatrix("2,4,6,8,10,12,14,16;1,3,5,7,9,11,13,15;2,3,5,7,11,13,17,19;81,89");
        matrix.prettyPrint();
    }
}
