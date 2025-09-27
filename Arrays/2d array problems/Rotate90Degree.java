//48. Rotate Image Leetcode

// You are given an n x n 2D matrix representing an image,
// rotate the image by 90 degrees (clockwise).

// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
// DO NOT allocate another 2D matrix and do the rotation.

public class Rotate90Degree {

    public static void transpose(int matrix[][]) {
        int n = matrix.length;
        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {
                // swap it
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        // revese the each row
        for (int row = 0; row < n; row++) {
            reverse(matrix[row]);
        }
    }

    public static void reverse(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int matrix[][] = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
        // output should be
        // [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

        // TO Rotate the matrix in 90^ transponse the matrix first and then do one by by
        // one reverse
        // Transponse will be and then reverse it
        // 5,2,13,15 ==>15,13,2,5
        // 1,4,3,14 ==>14,3,4,1
        // 9,8,6,12 ==> 12,6,8,9
        // 11,10,7,16 ==> 16,7,10,11

        transpose(matrix);

    }
}
