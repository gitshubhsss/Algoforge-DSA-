import java.util.ArrayList;

public class Nqueens {

    public static ArrayList<ArrayList<String>> printSolution(boolean[][] board) {

        ArrayList<ArrayList<String>> ansList = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {

            ArrayList<String> ans = new ArrayList<>();

            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == true) {
                    System.out.print("Q ");
                    ans.add("Q");

                } else {
                    System.out.print(". ");
                    ans.add(". ");
                }
            }
            ansList.add(ans);
            System.out.println();
        }
        return ansList;

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

    public static ArrayList<ArrayList<String>> nQueens(boolean[][] board, int n, int row) {

        if (row == n) {
            // print th solution
            System.out.println("==================");
            ArrayList<ArrayList<String>> baseAns = printSolution(board);
            return baseAns;
        }
        ArrayList<ArrayList<String>> myAns = new ArrayList<>();
        for (int col = 0; col < n; col++) {
            if (isSafeToPlaceHere(board, row, col, n)) {
                board[row][col] = true;
                ArrayList<ArrayList<String>> smallAns = nQueens(board, n, row + 1);
                for (ArrayList<String> ans : smallAns) {
                    myAns.add(ans);
                }
                board[row][col] = false;
            }
        }
        return myAns;

    }

    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        nQueens(board, n, 0);
        System.out.println("printint the nquesns problem");
        System.out.println(nQueens(board, n, 0));

    }
}
