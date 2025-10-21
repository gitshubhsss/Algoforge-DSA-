public class Nqueens {

    public static void printSolution(boolean[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == true) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }

    }

    public static boolean isSafeToPlaceHere(boolean[][] board, int row, int col, int n) {
        int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };

        // we only need to look at top-left ,top ,top -right
        // int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, };

        for (int distance = 1; distance <= n; distance++) {
            for (int[] dir : dirs) {
                int nRow = row + (distance * dir[0]);
                int nCol = col + (distance * dir[1]);
                if (nRow >= 0 && nCol >= 0 && nRow < n && nCol < n && board[nRow][nCol] == true) {
                    return false;
                }
            }
        }

        return true;

    }

    public static void nQueens(boolean[][] board, int n, int row) {

        if (row == n) {
            // print th solution
            printSolution(board);
            System.out.println("==================");
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafeToPlaceHere(board, row, col, n)) {
                board[row][col] = true;
                nQueens(board, n, row + 1);
                board[row][col] = false;
            }
        }

    }

    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        nQueens(board, n, 0);

    }
}
