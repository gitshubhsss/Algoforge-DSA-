public class PrintInWawes {
    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 },
                { 17, 18, 19, 20 } };

        int total_number_rows = matrix.length;
        int total_number_cols = matrix[0].length;

        for (int col = 0; col < total_number_cols; col++) {

            int colNumber = col;
            if (colNumber % 2 == 0) {
                // prin the element in the vertical fashion
                for (int row = 0; row < total_number_rows; row++) {
                    System.out.print(matrix[row][col] + " ");
                }
            } else {
                // print the element in the reverse fashon
                for (int row = total_number_rows - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col] + " ");
                }
            }

        }
    }
}
