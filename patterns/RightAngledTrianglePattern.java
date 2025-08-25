import java.util.Scanner;

public class RightAngledTrianglePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of lines ");
        int total_number_of_rows = sc.nextInt();
        // Number of stars in the first line
        int stars = 1;
        // Number of spaces in the first line
        int spaces = total_number_of_rows - 1;

        int row = 1;
        while (row <= total_number_of_rows) {

            // Print stars
            for (int i = 1; i <= stars; i++) {
                System.out.print("* ");
            }

            // Print spaces

            // Prepare for the next line
            System.out.println();

            stars++;
            spaces--;
            row++;

        }
    }
}

// * 
// * * 
// * * * 
// * * * * 
// * * * * *
// * * * * * *
