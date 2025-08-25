import java.util.Scanner;

public class NumberCrownPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int total_number_rows = sc.nextInt();
        int total_number_cols = total_number_rows * 2;

        int spaces = total_number_cols - 2;
        int row = 1;

        while (row <= total_number_rows) {

            // Print the initial numbers
            for (int i = 1; i <= row; i++) {
                System.out.print(i);
            }

            // Print the spaces

            for (int i = 1; i <= spaces; i++) {
                System.out.print(" ");
            }

            // Print the ending numbers
            for (int i = row; i >= 1; i--) {
                System.out.print(i);
            }

            // Prepare for the nexxt line
            System.out.println();

            spaces = spaces - 2;
            row++;

        }

    }
}

// 1        1
// 12      21
// 123    321
// 1234  4321
// 1234554321
