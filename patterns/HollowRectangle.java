import java.util.*;

public class HollowRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of stars on the first line");
        int n = sc.nextInt();
        int total_number_of_rows = n;
        int total_number_columns = n;

        int row = 0;
        while (row < total_number_of_rows) {

            for (int col = 0; col < total_number_columns; col++) {
                if ((col == 0 || col == n - 1) || (row == 0 || row == n - 1)) {
                    System.out.print("*");
                } else {
                    // Print the space
                    System.out.print(" ");
                }
            }

            // Prepare for the next line
            System.out.println();
            row++;

        }
    }
}

// *****
// *   *
// *   *
// *   *
// *****