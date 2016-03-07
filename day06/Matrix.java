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

    public void setMatrix(String matrixValues) {
        String[] rows = matrixValues.split(";");
        // loop over rows and columns of our matrix
        // so we can avoid index out of bounds if our values
        // are invalid
        if (rows.length > matrix.length) {
            System.out.print("Values provided were for " + rows.length + " rows, ");
            System.out.println("matrix has " + matrix.length + " rows");
        } else {
            for (int r = 0; r < matrix.length; r++) {
                String[] columns = rows[r].split(",");
                // loop over columns of matrix as above
                if (columns.length > matrix[r].length) {
                    System.out.print("Values provided were for " + columns.length + " columns, ");
                    System.out.println("matrix has " + matrix[0].length + " columns");
                    break;
                } else {
                    for (int c = 0; c < matrix[r].length; c++) {
                        matrix[r][c] = Integer.parseInt(columns[c]);
                    }
                }
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
        String[] rows = new String[matrix.length];

        for (int r = 0; r < matrix.length; r++) {
            String[] cols = new String[matrix[r].length];
            for (int c = 0; c < matrix[r].length; c++) {
                cols[c] =  "" + matrix[r][c];
            }
            rows[r] = String.join(",", cols);
        }
        return "[" + String.join(";", rows) +"]";
    }

    public void prettyPrint () {
        String[] rows = new String[matrix.length + 1];

        // add the column header row
        String[] header = new String[matrix[0].length + 1];
        header[0] = "";
        for (int col = 0; col < matrix[0].length; col++) {
            header[col + 1] = "Col" + col;
        }
        rows[0] = String.join("\t", header);

        for (int r = 0; r < matrix.length; r++) {
            String[] cols = new String[matrix[r].length + 1];
            // add the row header
            cols[0] = "Row" + r;
            for (int c = 0; c < matrix[r].length; c++) {
                cols[c + 1] = "" + matrix[r][c];
            }
            rows[r + 1] = String.join("\t", cols);
        }

        System.out.println(String.join("\n", rows));
    }
}
