public class Matrix {

    private int[][] matrix;

    public Matrix (int rows, int cols) {
        matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = 1;
            }
        }
    }

    public void setElement (int row, int col, int val) {
        // set value only if indices are correct
        if (row < matrix.length && col < matrix[row].length) {
            matrix[row][col] = val;
        }
    }

    public void setRow (int row, String values) {
        if (row < matrix.length) {
            // valid length, check the values
            String[] str = values.split(",");
            // split the string to an array of strings on ","
            // so we can get the length
            // and use the array if valid
            if (str.length == matrix[row].length) {
                // if row = 3
                // matrix[3][0] = str[0]
                for (int i = 0; i < matrix[row].length; i++) {
                    matrix[row][i] = Integer.parseInt(str[i]);
                }
            }
        }
    }

    public void setColumn (int col, String values) {
        // As we initialised this matrix with equal length columns
        // assume we can safely check the length of column at matrix[0]
        if (col < matrix[0].length) {
            // splitting as above
            String[] str = values.split(",");
            if (str.length == matrix.length) {
                // if column = 2
                // matrix [0][2] = str[0]
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][col] = Integer.parseInt(str[i]);
                }
            }
        }
    }

    public String toString () {
        String result = "[";

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                result += matrix[r][c];
                // add column delimiter
                if (c != matrix[r].length - 1) {
                    result += ",";
                }
            }
            // add row delimiter
            if (r != matrix.length - 1) {
                result += ";";
            }
        }
        result += "]";
        return result;
    }

    public void prettyPrint () {
        String cols = "\t";
        for (int col = 0; col < matrix[0].length; col++) {
            cols += "Col" + col;
            if (col != matrix[0].length - 1) {
                cols += "\t";
            }
        }
        System.out.println(cols);

        for (int r = 0; r < matrix.length; r++) {
            String row = "";
            for (int c = 0; c < matrix[r].length; c++) {
                row += matrix[r][c];
                // store the columns for this row
                if (c != matrix[r].length - 1) {
                    row += "\t";
                }
            }

            // print each row
            System.out.println("Row" + r + "\t" + row);
        }
    }
}
