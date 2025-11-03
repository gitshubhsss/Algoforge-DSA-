public class NQueens {

    public static void printChessBoard(boolean[][] chessBoard) {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[0].length; j++) {
                if (chessBoard[i][j] == true) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }

            }
            System.out.println();

        }
        System.out.println("==========================");
    }

    public static boolean isSafeToPlaceHere(boolean[][] chessBoard, int row, int col, int n) {

        // top left , top, top-right
        int dirs[][] = { { -1, -1 }, { -1, 0 }, { -1, 1 } };

        for (int distance = 1; distance <= Math.min(row, n); distance++) {
            for (int[] dir : dirs) {
                int newRow = row + distance * dir[0];
                int newCol = col + distance * dir[1];
                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < n && chessBoard[newRow][newCol] == true) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void nqueens(boolean[][] chessBoard, int n, int row) {

        if (row == n) {
            // return and print the solution
            printChessBoard(chessBoard);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafeToPlaceHere(chessBoard, row, col, n)) {
                chessBoard[row][col] = true;
                nqueens(chessBoard, n, row + 1);
                chessBoard[row][col] = false;
            }
        }

    }

    public static void main(String[] args) {
        int n = 4;
        boolean[][] chessBoard = new boolean[n][n];
        nqueens(chessBoard, n, 0);
    }
}
