public class Main {
    public static void main(String[] args) {

        int arr[][] = { { 1, 2, 3, }, { 6, 7, 9, }, { 12, 13, 14, }, };

        int start_row = 0;
        int end_row = arr.length - 1;// 3
        int start_col = 0;
        int end_col = arr[0].length - 1;// 3

        while (start_row <= end_row && start_col <= end_col) {

            // print the left wall
            for (int row = start_row; row <= end_row; row++) {// o to 3
                System.out.print(arr[row][start_col] + " ");// 1,6,12,17
            }
            start_col++;// 1

            // print the down wall
            for (int col = start_col; col <= end_col; col++) {// 1 to 3
                System.out.print(arr[end_row][col] + " ");// 18, 19, 20, 21
            }
            end_row--;// 2

            // print the right wall
            for (int row = end_row; row >= start_row; row--) {// 2to 0
                System.out.print(arr[row][end_col] + " ");// 16,115
            }
            end_col--;

            // print he upper wall
            for (int col = end_col; col >= start_col; col--) {
                System.out.print(arr[start_row][col] + " ");
            }
            start_row++;
        }
    }
}