public class Main {

    // DFS
    public static void floodFill(int row, int col, int mat[][], boolean visited[][], int n, int m, String asf) {

        // TODO Negative indexing
        if (row < 0 || col < 0) {
            return;
        }

        if (row >= n || col >= m || mat[row][col] == 1 || visited[row][col] == true) {
            return;
        }

        // Reached to destination print the path
        if (row == n - 1 && col == m - 1) {
            System.out.println(asf);
            return;
        }

        // TO Avoid the circular loop
        visited[row][col] = true;

        // go top
        floodFill(row - 1, col, mat, visited, n, m, asf + "t");

        // go left
        floodFill(row, col - 1, mat, visited, n, m, asf + "l");

        // go down
        floodFill(row + 1, col, mat, visited, n, m, asf + "d");

        // go right
        floodFill(row, col + 1, mat, visited, n, m, asf + "r");

        // While going back making the cell false to explore the more paths in future
        visited[row][col] = false;
    }

    public static void main(String args[]) {

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