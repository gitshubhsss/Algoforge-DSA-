import java.util.Scanner;

public class InvertedRightPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of starts");
        int n = sc.nextInt();
        int total_number_of_rows = n;

        int row = 1;

        // Stars in the first line

        int stars = n;
        int spaces = 0;
        while (row <= total_number_of_rows) {

            // print stars
            for (int i = 1; i <= stars; i++) {
                System.out.print("*");
            }

            // print spaces
            for (int i = 1; i <= spaces; i++) {
                System.out.print(" ");
            }

            // prepare for the next line
            System.out.println();
            stars--;
            spaces++;
            row++;
        }
    }
}
