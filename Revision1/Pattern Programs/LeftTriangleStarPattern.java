import java.util.Scanner;

public class LeftTriangleStarPattern {
    public static void main(String[] args) {

        System.out.println("Enter the total number of lines");

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int total_number_of_lines = n;
        int current_number_of_line = 1;

        int spaces = n - 1;
        int stars = 1;

        while (current_number_of_line <= total_number_of_lines) {

            // print spaces
            for (int i = 1; i <= spaces; i++) {
                System.out.print(" ");
            }
            // print stars
            for (int i = 1; i <= stars; i++) {
                System.out.print("* ");
            }

            // prepare for the next line
            stars++;
            spaces--;
            current_number_of_line++;
            System.out.println();
        }
    }
}