public class SearchInSortedArray {

    public static int[] searchIndexWithBinarySearchWithColumn(int matrix[][], int target) {
        // 0 ==> 1, 5, 8, 11, 19
        // 1 ==> 2, 10, 12, 21, 22
        // 2 ==> 29, 40, 45, 48, 68
        // 3 ==> 35, 46, 53, 98, 101
        // 4 ==> 37, 51, 54, 110, 120
        // so will go to each array will do the binary search on each arry we we get the
        // position
        // will return the index

        int n = matrix.length;
        // Column will be 0,1,2,3,4
        for (int col = 0; col < n; col++) {
            int start = 0;
            int end = n - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                // Column remains costant here
                if (matrix[col][mid] == target) {
                    return new int[] { col, mid };
                } else if (matrix[col][mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return new int[] { -1, -1 };
    }

    //
    public static int[] searchIndexWithBinarySearchWithRow(int matrix[][], int target) {
        // 0 ==> 1, 5, 8, 11, 19
        // 1 ==> 2, 10, 12, 21, 22
        // 2 ==> 29, 40, 45, 48, 68
        // 3 ==> 35, 46, 53, 98, 101
        // 4 ==> 37, 51, 54, 110, 120
        // so will go to each array will do the binary search on each arry we we get the
        // position
        // will return the index

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            // Do the binary search on each array
            int arr[] = matrix[i];
            // initialize the pointers
            int start = 0;
            int end = arr.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;// find the mid
                if (arr[mid] == target) {
                    return new int[] { i, mid };// retrun the row number and the inner index number
                } else if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return new int[] { -1, -1 };
    }

    // so you will be given a matrix and a target element
    public static int[] searchIndexWithNlogN(int matrix[][], int target) {
        // 1, 5, 8, 11, 19
        // 2, 10, 12, 21, 22
        // 29, 40, 45, 48, 68
        // 35, 46, 53, 98, 101
        // 37, 51, 54, 110, 120

        // so the reson we choose the end col as the first element cause
        // So we can choose two pointers

        // 1====> 0,m-1;
        // if you geet the greater element go down if you get the smaller element go in
        // left
        // 2====> n-1,0;
        // if you get a greater element go right if you get the smaller element go up

        int n = matrix.length;
        int m = matrix[0].length;

        int row = n - 1;// starting point
        int col = 0;

        while (row >= 0 && col < m) {

            if (matrix[row][col] == target) {
                return new int[] { row, col };
            }
            if (matrix[row][col] < target) {
                col++;
            } else {
                row--;
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        // the matrix is sorted in row wise fashion and column wise also the matrix is
        // sorted

        int matrix[][] = { { 1, 5, 8, 11, 19 }, { 2, 10, 12, 21, 22 }, { 29, 40, 45, 48, 68 }, { 35, 46, 53, 98, 101 },
                { 37, 51, 54, 110, 120 } };

        // int positions[] = searchIndexWithBinarySearchWithColumn(matrix, 10);
        int positions[] = searchIndexWithNlogN(matrix, 46);
        System.out.println(positions[0]);
        System.out.println(positions[1]);
    }
}
