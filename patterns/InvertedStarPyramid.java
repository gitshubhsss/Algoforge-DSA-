import java.util.Scanner;

public class InvertedStarPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int total_number_of_rows = sc.nextInt();

        int stars = (total_number_of_rows * 2) - 1;

        int space = 0;

        int row = 1;
        while (row <= total_number_of_rows) {

            // Print spaces
            for (int i = 1; i <= space; i++) {
                System.out.print(" ");
            }

            // Print stars

            for (int i = 1; i <= stars; i++) {
                System.out.print("*");
            }

            // Prepare for the next line
            System.out.println("");

            row++;
            stars = stars - 2;
            space++;
        }
    }
}

// *********
//  *******
//   *****
//    ***
//     *
