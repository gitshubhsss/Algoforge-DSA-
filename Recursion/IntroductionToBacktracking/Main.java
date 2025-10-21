public class Main {

    public static void permutations(String str, String asf) {

        if (str.isEmpty()) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char firstChar = str.charAt(i);
            String leftRemaining = str.substring(0, i);
            String rightRemaining = str.substring(i + 1);
            permutations(leftRemaining + rightRemaining, asf + firstChar);
        }
    }

    public static int maxPathSum(int arr[][], int row, int col) {

        // We reached to the galat index
        if (row >= arr.length || col >= arr[0].length) {
            return Integer.MIN_VALUE;
        }

        // when we reach the last index
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            return arr[row][col];
        }

        int horizontalMax = maxPathSum(arr, row, col + 1);
        int verticalMax = maxPathSum(arr, row + 1, col);

        int myMaxPath = arr[row][col] + Math.max(horizontalMax, verticalMax);
        return myMaxPath;

    }

    // DFS
    public static void floodFill(int row, int col, int mat[][], boolean visited[][], int n, int m, String asf) {

        if (row < 0 || col < 0) {
            return;
        }
        if (row >= n || col >= m || mat[row][col] == 1 || visited[row][col] == true) {
            return;
        }

        if (row == n - 1 && col == m - 1) {
            System.out.println(asf);
            return;
        }

        visited[row][col] = true;

        // go top
        floodFill(row - 1, col, mat, visited, n, m, asf + "t");

        // go left
        floodFill(row, col - 1, mat, visited, n, m, asf + "l");

        // go down
        floodFill(row + 1, col, mat, visited, n, m, asf + "d");

        // go right
        floodFill(row, col + 1, mat, visited, n, m, asf + "r");
        visited[row][col] = false;
    }

    // 123
    public static void printSubSequece(int arr[], int idx, String asf, int tar) {
        if (idx == arr.length) {
            if (tar == 0) {
                System.out.println(asf);
                return;
            }
            return;
        }
        int ele = arr[idx];
        // first char will say yes
        printSubSequece(arr, idx + 1, asf + ele, tar - ele);
        // first char will say no
        printSubSequece(arr, idx + 1, asf, tar);

    }

    public static void main(String args[]) {
        // int[][] mat = { { 10, -11, 4 }, { -13, 19, 6 } };
        // System.out.println(maxPathSum(mat, 0, 0));
        // int[][] mat = { { 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 1, 0 },
        // { 0, 0, 0, 0, 0, 0, }, { 0, 1, 0, 1, 1, 0 },
        // { 0, 1, 0, 1, 1, 0 }, { 0, 0, 0, 1, 1, 0 } };
        // ;
        // int n = mat.length;
        // int m = mat[0].length;
        // boolean visited[][] = new boolean[n][m];
        // floodFill(0, 0, mat, visited, n, m, "");

        int arr[] = { 2, 5, 3, 4, -4, 8, 6, -8 };
        printSubSequece(arr, 0, "", 8);
    }
}