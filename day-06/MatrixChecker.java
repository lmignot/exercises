import java.util.Arrays;

public class MatrixChecker {

    public boolean isSymmetrical (int[] ints) {
        if (ints.length == 0 || ints.length == 1) {
            return true;
        }

        if (ints[0] == ints[ints.length - 1]) {
            int[] reduced = Arrays.copyOfRange(ints, 1, ints.length - 1);
            return isSymmetrical(reduced);
        } else {
            return false;
        }
    }

    public boolean isSymmetrical (int[][] matrix) {
        // given the rule from the exercise:
        // An matrix is symmetrical if m[i][j] == m[j][i] for any value of i and j.
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.println(matrix[row][col]);
                System.out.println(matrix[col][row]);
                if(matrix[row][col] != matrix[col][row]) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isTriangular (int[][] matrix) {
        return true;
    }

}