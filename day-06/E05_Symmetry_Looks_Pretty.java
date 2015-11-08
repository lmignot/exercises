// E05 Symmetry Looks Pretty

public class E05_Symmetry_Looks_Pretty {

    public static void main (String[] args) {
        MatrixChecker matrixChecker = new MatrixChecker();
        int[] symmetricalArr = {1,3,5,7,7,5,3,1};
        int[] asymmetricalArr = {2,5,7,3,2,6,3,6};

        System.out.println("symmetrical check ({1,3,5,7,7,5,3,1}): " + matrixChecker.isSymmetrical(symmetricalArr));
        System.out.println("asymmetrical check ({2,5,7,3,2,6,3,6}): " + !matrixChecker.isSymmetrical(asymmetricalArr));

        int[][] matrix = {{1,9,8},{9,7,6},{8,6,5}};

        System.out.println("a matrix ({{1,9,8},{9,7,6},{8,6,5}}) is symmetrical: " + matrixChecker.isSymmetrical
                (matrix));

        int[][] triangular = {{1,2,4,5},{0,1,2,4},{0,0,1,2},{0,0,0,1}};

        System.out.println("a matrix ({{1,2,4,5},{0,1,2,4},{0,0,1,2},{0,0,0,1}}) is triangular: " + matrixChecker
                .isTriangular
                (triangular));
    }
}
