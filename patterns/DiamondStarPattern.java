import java.util.Scanner;

public class DiamondStarPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n : ");
        int n = sc.nextInt();

        int total_number_of_rows = n * 2;

        int row = 1;
        int stars = 1;
        int spacing = n - 1;

        while (row <= total_number_of_rows) {
            // Print spacing
            for (int i = 1; i <= spacing; i++) {
                System.out.print(" ");
            }

            // Print stars
            for (int i = 1; i <= stars; i++) {
                System.out.print("*");
            }

            // Prepare for the next line
            System.out.println();

            if (row < n) {
                stars = stars + 2;
                spacing--;
            } else if (row == n) {
                stars = n * 2 - 1;
                spacing = 0;
            } else {
                stars = stars - 2;
                spacing++;
            }
            row++;
        }
    }
}

//     *
//    ***
//   *****
//  *******
// *********
// *********
//  *******
//   *****
//    ***
//     *
