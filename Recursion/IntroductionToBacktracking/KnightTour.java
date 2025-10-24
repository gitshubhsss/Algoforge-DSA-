public class KnightTour {

    public static void printBoard(int board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // given by madhav malholtra
    public static int[][] dire = { { -2, 1 }, { -2, -1 }, { 1, -2 }, { -1, -2 }, { 0, 2 }, { 2, 1 }, { 2, -1 } };

    public static void knightTour(int row, int col, int[][] board, int currentStep) {

        // base case
        if (row < 0 || col < 0 || col >= board.length || row >= board.length || board[row][col] != 0) {
            return;
        }
        if (currentStep == 65) {
            // print the board here
            printBoard(board);
            return;
        }

        board[row][col] = currentStep;

        // make the function calls
        printBoard(board);
        System.out.println("===================");

        knightTour(row - 2, col - 1, board, currentStep + 1);
        knightTour(row - 2, col + 1, board, currentStep + 1);

        knightTour(row - 1, col + 2, board, currentStep + 1);
        knightTour(row + 1, col + 2, board, currentStep + 1);

        knightTour(row + 2, col + 1, board, currentStep + 1);
        knightTour(row + 2, col - 1, board, currentStep + 1);

        knightTour(row + 1, col - 2, board, currentStep + 1);
        knightTour(row - 1, col - 2, board, currentStep + 1);

        board[row][col] = 0;

    }

    public static void main(String[] args) {
        int[][] board = new int[8][8];

        knightTour(5, 4, board, 1);
    }
}