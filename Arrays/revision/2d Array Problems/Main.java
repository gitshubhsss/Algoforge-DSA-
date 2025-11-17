public class Main {

    // 2D Array questions

    // Helper function to print the 2d array
    public static void print2dMatrix(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[0].length; j++) {

                System.out.print(arr[i][j] + " ");
            }

            System.out.println();

        }
    }

    // helper funtion to print the array

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Sheet Problem 1
    public static int[][] multiplyTwoMatrix(int[][] mat1, int[][] mat2) {

        int r1 = mat1.length;
        // int c1 = mat1[0].length;

        int r2 = mat2.length;
        int c2 = mat2[0].length;

        int ans[][] = new int[r1][c2];

        if (r1 != c2) {
            System.out.println("Multiplication cant happens");
            return new int[][] {};
        }

        for (int i = 0; i < r1; i++) {

            for (int j = 0; j < c2; j++) {

                int mul = 0;

                for (int k = 0; k < r2; k++) {

                    mul = mul + (mat1[i][k] * mat2[k][j]);

                }
                ans[i][j] = mul;

            }
        }

        return ans;
    }

    // Sheet problem 2
    public static void printWaveTraversal(int[][] mat) {

        for (int col = 0; col < mat[0].length; col++) {

            if (col % 2 == 0) {
                for (int row = 0; row < mat.length; row++) {
                    System.out.print(mat[row][col] + " ");
                }
            } else {
                for (int row = mat.length - 1; row >= 0; row--) {
                    System.out.print(mat[row][col] + " ");
                }
            }

        }

    }

    // Sheet problem 2

    public static int[] findExitPoint(int n, int m, int[][] matrix) {

        // initial pointers

        int row = 0;
        int col = 0;

        int dir = 0;

        while (row < n && row >= 0 && col < m && col >= 0) {

            if (matrix[row][col] == 1) {
                matrix[row][col] = 0;
                dir = (dir + 1) % 4;
            }
            if (dir == 0) {
                col++; // Right
            } else if (dir == 1) {
                row++;// down
            } else if (dir == 2) {
                col--;// left
            } else if (dir == 3) {
                row--;// up
            }
        }

        if (row > n) {
            row--;
        }
        if (col > m) {
            col--;
        }

        if (col < 0) {
            col++;
        }

        if (row < 0) {
            row++;
        }

        return new int[] { row, col };

    }

    public static void spiralOrder(int[][] matrix) {

        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startRow >= 0 && startCol <= endCol && startCol >= 0) {

            // upper wall
            for (int col = startCol; col <= endCol; col++) {
                System.out.print(matrix[startRow][col] + " ");
            }
            startRow++;// 1

            // right wall

            for (int row = startRow; row <= endRow; row++) {
                System.out.print(matrix[row][endCol] + " ");
            }

            endCol--;

            // down wall
            for (int col = endCol; col >= startCol; col--) {
                if (endCol == startCol) {
                    continue;
                }
                System.out.print(matrix[endRow][col] + " ");
            }

            endRow--;

            // left wall

            for (int row = endRow; row >= startRow; row--) {
                System.out.print(matrix[row][startCol] + " ");
            }
            startCol++;
        }
    }

    // Funtion to do transpose of the matrix inplace
    public static void transposeMatrix(int matrix[][]) {

        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void reverseArray(int arr[]) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    // Function to rotate the matrix
    public static void rotateMatrix(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Transpose
        print2dMatrix(matrix);

        for (int i = 0; i < n; i++) {
            reverseArray(matrix[i]);
        }

        System.out.println("After reversing each array");

        print2dMatrix(matrix);

    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;

        int col = m - 1;

        while (row < n && row >= 0 && col >= 0 && col < m) {

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // int mat1[][] = { { 2, 2, 3 }, { 5, 4, 3 } };
        // int mat2[][] = { { 5, 2 }, { 4, 1 }, { 3, 5 } };

        // int ans[][] = multiplyTwoMatrix(mat1, mat2);

        // print2dMatrix(ans);

        // printWaveTraversal(mat1);

        // int matrix[][] = { { 0, 1, 0 }, { 0, 1, 1 }, { 0, 0, 0 } };

        // int exitPoints[] = findExitPoint(matrix.length, matrix[0].length, matrix);

        // printArray(exitPoints);

        // int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        // spiralOrder(matrix);

        // transposeMatrix(matrix);

        // rotateMatrix(matrix);

        int matrix[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };

        System.out.println(searchMatrix(matrix, 3));

    }
}