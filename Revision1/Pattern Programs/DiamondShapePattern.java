import java.util.Scanner;

public class DiamondShapePattern {
    public static void main(String[] args) {
        System.out.println("Enter the value of n");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int total_number_of_lines = n * 2 - 1;
        int current_number_of_lines = 1;

        int stars = 1;
        int spaces = n - 1;

        while (current_number_of_lines <= total_number_of_lines) {
            // print space
            for (int i = 1; i <= spaces; i++) {
                System.out.print(" ");
            }

            // print stars
            for (int i = 1; i <= stars; i++) {
                System.out.print("*");
            }
            // prepare for the next line

            if (current_number_of_lines < n) {
                stars = stars + 2;
                spaces--;
            } else {
                stars = stars - 2;
                spaces++;
            }
            current_number_of_lines++;
            System.out.println();
        }

        sc.close();

    }
}

// Input: number = 7
// *
// ***
// *****
// *******
// *********
// ***********
// *************
// ***********
// *********
// *******
// *****
// ***
// *
