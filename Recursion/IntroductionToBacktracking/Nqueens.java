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

    public static ArrayList<ArrayList<String>> nQueens(boolean[][] board, int n,
            int row) {

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

    public static int nQueensOptimized(boolean[] colVis, boolean[] diaVis, boolean[] antiDiaVis, int n, int row) {

        if (row == n) {
            return 1;
        }

        int ans = 0;

        for (int col = 0; col < n; col++) {

            if (colVis[col] == false && diaVis[col - row + n - 1] == false && antiDiaVis[row + col] == false) {

                colVis[col] = true;
                diaVis[col - row + n - 1] = true;
                antiDiaVis[row + col] = true;

                ans = ans + nQueensOptimized(colVis, diaVis, antiDiaVis, n, row + 1);

                colVis[col] = false;
                diaVis[col - row + n - 1] = false;
                antiDiaVis[row + col] = false;

            }
        }
        return ans;
    }

    public static int setKthBitTrue(int num, int k) {
        int mask = (1 << k);
        int newNum = num | mask;
        return newNum;

    }

    public static int setKthBitFalse(int num, int k) {
        int mask = ~(1 << k);
        int newNum = num & mask;
        return newNum;
    }

    public static boolean checkKthBit(int num, int k) {
        int mask = (1 << k);
        if ((num & mask) > 0) {
            return true;
        }

        return false;
    }

    public static int NQueensMostOptimised(int row, int n, int colNum, int diagNum, int aDiagNum) {
        if (row == n) {
            return 1;
        }

        int ans = 0;
        for (int col = 0; col < n; col++) {
            if (checkKthBit(colNum, col) == false && !checkKthBit(diagNum, col - row + n - 1)
                    && !checkKthBit(aDiagNum, row + col)) {

                colNum = colNum | (1 << col);
                diagNum = diagNum | (1 << (col - row + n - 1));
                aDiagNum = setKthBitTrue(aDiagNum, row + col); // aDiagNum | (1 << (row+col))

                ans = ans + NQueensMostOptimised(row + 1, n, colNum, diagNum, aDiagNum);

                colNum = colNum & ~(1 << col);
                diagNum = diagNum & ~(1 << (col - row + n - 1));
                aDiagNum = aDiagNum & ~(1 << (row + col));
            }
        }
        return ans;
    }

    // letcode 52

    public static void main(String[] args) {
        // int n = 4;
        // boolean[][] board = new boolean[n][n];

        // boolean colVis[] = new boolean[n];
        // boolean diaVis[] = new boolean[(2 * n) - 1];
        // boolean antiDiaVis[] = new boolean[(2 * n) - 1];
        // nQueens(board, n, 0);

        // System.out.println(nQueensOptimized(colVis, diaVis, antiDiaVis, n, 0));

        System.out.println(NQueensMostOptimised(0, 4, 0, 0, 0));

    }
}
