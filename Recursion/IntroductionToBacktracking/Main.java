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
    public static void floodFill(int row, int col, int[][] mat, boolean[][] visited, int n, int m, String psf) {

        // base case
        if (row < 0 || col < 0 || row >= n || col >= m || mat[row][col] == 1 || visited[row][col] == true) {
            return;
        }
        if (row == n - 1 && col == m - 1) {
            System.out.println(psf);
            return;
        }

        visited[row][col] = true;
        // go top
        floodFill(row - 1, col, mat, visited, n, m, "t" + psf);
        // go left
        floodFill(row, col - 1, mat, visited, n, m, "l" + psf);
        // go down
        floodFill(row + 1, col, mat, visited, n, m, "d" + psf);
        // go right
        floodFill(row, col + 1, mat, visited, n, m, "d" + psf);
        visited[row][col] = false;
    }

    public static void main(String args[]) {
        // int[][] mat = { { 10, -11, 4 }, { -13, 19, 6 } };
        // System.out.println(maxPathSum(mat, 0, 0));
        int[][] mat = { { 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 0, }, { 0, 1, 0, 1, 1, 0 },
                { 0, 1, 0, 1, 1, 0 }, { 0, 0, 0, 1, 1, 0 } };
        ;
        int n = mat.length;
        int m = mat[0].length;
        boolean visited[][] = new boolean[n][m];

        floodFill(0, 0, mat, visited, n, m, "");
    }
}