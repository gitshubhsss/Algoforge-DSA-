import java.util.ArrayList;
import java.util.List;

public class NQueensLeetcode {

    public static List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return nQueens(board, n, 0);
    }

    public static List<List<String>> nQueens(boolean[][] board, int n, int row) {

        if (row == n) {
            return fillQueens(board);
        }

        List<List<String>> myAns = new ArrayList<>();

        for (int col = 0; col < n; col++) {
            if (isSafeToPlaceHere(board, row, col, n)) {
                board[row][col] = true;
                List<List<String>> smallerAns = nQueens(board, n, row + 1);
                for (List<String> queen : smallerAns) {
                    myAns.add(queen);
                }
                board[row][col] = false;
            }
        }
        return myAns;

    }

    public static boolean isSafeToPlaceHere(boolean[][] board, int row, int col, int n) {
        int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 } };

        for (int distance = 1; distance <= Math.min(row, n); distance++) {
            for (int dir[] : dirs) {
                int nRow = row + (distance * dir[0]);
                int nCol = col + (distance * dir[1]);

                if (nRow >= 0 && nCol >= 0 && nRow < n && nCol < n && board[nRow][nCol] == true) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<List<String>> fillQueens(boolean[][] board) {
        List<List<String>> myAns = new ArrayList<>();
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {

            String str = "";
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == true) {
                    str = str + "Q";
                } else {
                    str = str + ".";
                }
            }
            strList.add(str);
        }
        myAns.add(strList);
        return myAns;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
