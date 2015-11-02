// E03 Matrix


public class E03_Matrix {

    public static void main (String[] args) {
        Matrix matrix = new Matrix(4, 9);
        System.out.println("Initialised new matrix with 4 rows and 9 columns");
        System.out.println(matrix.toString());
        matrix.setElement(0, 0, 2);
        System.out.println("Set element at matrix[0][0] to 2");
        System.out.println(matrix.toString());
        matrix.setElement(5, 1, 8);
        System.out.println("Tried to set element at matrix[5][1] to 8");
        System.out.println(matrix.toString());
        matrix.setRow(2, "1,3,5,7,9,11,13,15,17");
        System.out.println("Set row 2 with values: 1,3,5,7,9,11,13,15,17");
        System.out.println(matrix.toString());
        matrix.setColumn(7, "81,82,83,84");
        System.out.println("Set column 7 with values: 81,82,83,84");
        System.out.println(matrix.toString());
        matrix.prettyPrint();
    }

}
