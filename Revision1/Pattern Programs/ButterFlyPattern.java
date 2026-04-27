import java.util.Scanner;

public class ButterFlyPattern {
    public static void main(String[] args) {
        System.out.println("Enter the value of n");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int total_number_of_lines = n * 2 - 1; // if input ==5 then 9 lines
        int current_number_of_lines = 1;
        int right_stars = 1;
        int left_stars = 1;
        int spaces = total_number_of_lines - 2;

        while (current_number_of_lines <= total_number_of_lines) {
            // print the right stars
            for (int i = 1; i <= right_stars; i++) {
                System.out.print("* ");
            }

            // print the space
            for (int i = 1; i <= spaces; i++) {
                System.out.print("  ");
            }

            /// Handeling the middle *
            if (current_number_of_lines == n) {
                left_stars--;
            }
            // print the left stars
            for (int i = 1; i <= left_stars; i++) {
                System.out.print("* ");
            }

            // prepare for the next line
            if (current_number_of_lines < n) {
                right_stars++;
                left_stars++;
                spaces -= 2;
            } else {
                right_stars--;
                left_stars--;
                spaces += 2;
            }

            // reset the middle star
            if (current_number_of_lines == n) {
                left_stars++;
            }
            current_number_of_lines++;
            System.out.println();
        }
    }
}
