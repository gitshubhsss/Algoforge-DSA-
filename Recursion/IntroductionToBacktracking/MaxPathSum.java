public class MaxPathSum {

    public static int findMaxPath(int mat[][], int row, int col, int n, int m) {

        // base case
        if (row < 0 || col < 0 || row >= n || col >= m) {
            // invalid index
            return -1;
        }

        if (row == n-1 && col == m-1) {
            return mat[row][col];
        }

        int horizontalMax = findMaxPath(mat, row, col + 1, n, m );
        int verticalMax = findMaxPath(mat, row + 1, col, n, m);

    
        int ans = mat[row][col] + (int) Math.max(horizontalMax, verticalMax);
        return ans;
    }

    public static void main(String[] args) {
        int mat[][] = { { 2, 3 }, { 1, 5 } };
        int n = mat.length;
        int m = mat[0].length;

      //  System.out.println(findMaxPath(mat, 0, 0, n, m, ""));
    }
}
