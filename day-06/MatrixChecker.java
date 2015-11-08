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
        return true;
    }

    public boolean isTriangular (int[][] matrix) {
        return true;
    }

}