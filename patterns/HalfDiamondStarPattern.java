import java.util.Scanner;

public class HalfDiamondStarPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of N : ");
        int n = sc.nextInt();
        int total_number_of_rows = n * 2 - 1;
        int row = 1;

        int stars = 1;

        while (row <= total_number_of_rows) {
            // Print the stars

            for (int i = 1; i <= stars; i++) {
                System.out.print("*");
            }

            // Prepare for the next line
            System.out.println();
            if (row < n) {
                stars++;
            } else {
                stars--;
            }
            row++;

        }
         sc.close();
    }
}

// *
// **
// ***
// ****
// *****
// ****
// ***
// **
// *
