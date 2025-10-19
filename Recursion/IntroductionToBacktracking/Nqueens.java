public class Nqueens {

    public static void printSolution(boolean[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == true) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public static boolean isSafeToPlaceHere(boolean[][] board, int row, int col, int n) {
        // int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0
        // }, { 1, -1 }, { 0, -1 } };

        // we only need to look at top-left ,top ,top -right
        int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, };

        for(int dis=1;dis<=n;dis++){

        }

    }

    public static void nQueens(boolean[][] board, int n, int row) {

        if (row == n) {
            // print th solution
            printSolution(board);
            return;
        }

        for (int col = 0; col < n; col++) {
            board[row][col] = true;
            nQueens(board, n, row + 1);
            board[row][col] = false;
        }

    }

    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        nQueens(board, n, 0);

    }
}
