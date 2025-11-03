public class KnightTour {

    public static void printBoard(int board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + ",\t");
            }
            System.out.println();
        }
        System.out.println("==================");
    }

    public static void knightTour(int row, int col, int board[][], int currentStep) {

        if (currentStep == 65) {
            printBoard(board);
            return;
        }
        if (row < 0 || col < 0 || col >= board.length || row >= board.length || board[row][col] != 0) {
            return;
        }
        board[row][col] = currentStep;

        printBoard(board);
        System.out.println("==============================================");

        // will do it for the 8 directions
        knightTour(row - 2, col - 1, board, currentStep + 1);
        knightTour(row - 2, col + 1, board, currentStep + 1);

        knightTour(row - 1, col + 2, board, currentStep + 1);
        knightTour(row + 1, col + 2, board, currentStep + 1);

        knightTour(row + 2, col + 1, board, currentStep + 1);
        knightTour(row + 2, col - 1, board, currentStep + 1);

        knightTour(row - 1, col - 2, board, currentStep + 1);
        knightTour(row + 1, col - 2, board, currentStep + 1);

        board[row][col] = 0;

    }

    public static void main(String[] args) {
        int[][] board = new int[8][8];
        knightTour(5, 4, board, 1);
    }
}
