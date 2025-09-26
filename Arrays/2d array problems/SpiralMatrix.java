public class SpiralMatrix {
    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 },
                { 17, 18, 19, 20 } };

        // the output 1,5,9,13,18,13,20,16,12,8,4,3,2
        // 6,10,14,15,11,7,

        // initialize the points

        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startCol <= endCol && startRow <= endRow) {
            // print the left wall
            for (int row = startRow; row <= endRow; row++) {
                System.out.print(matrix[row][startCol] + " ");
            }
            startCol++;
            // print the bottom wall
            for (int col = startCol; col <= endCol; col++) {
                System.out.print(matrix[endRow][col] + " ");
            }
            endRow--;
            // prin the right wall

            for (int row = endRow; row >= startRow; row--) {
                System.out.print(matrix[row][endCol] + " ");
            }
            endCol--;
            // print the upper wall

            for (int col = endCol; col >= startCol; col--) {
                System.out.print(matrix[startRow][col] + " ");
            }
            startRow++;
        }

    }
}
