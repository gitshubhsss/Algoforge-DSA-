import java.util.Scanner;

public class Pattern4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of stars");
        int n = sc.nextInt();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 || row == n - 1 || col == 0 || col == n - 1 || (row + col == n - 1) || row == col) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}

// 7
// * * * * * * * 
// * *       * *
// *   *   *   *
// *     *     *
// *   *   *   *
// * *       * *
// * * * * * * *
