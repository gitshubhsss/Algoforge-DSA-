import java.util.Scanner;

public class Star5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of line");
        int n = sc.nextInt();
        int total_number_of_lines = n;

        int stars = n / 2 + 1;
        int spaces = 1;

        int current_number_of_line = 1;

        while (current_number_of_line <= total_number_of_lines) {
            // print stars

            for (int i = 1; i <= stars; i++) {
                System.out.print("* ");
            }
            // print space
            for (int i = 1; i <= spaces; i++) {
                System.out.print("  ");
            }

            // print stars
            for (int i = 1; i <= stars; i++) {
                System.out.print("* ");
            }

            // prepare for the next line
            System.out.println();
            if (current_number_of_line < n / 2 + 1) {
                spaces = spaces + 2;
                stars--;
            } else {
                spaces = spaces - 2;
                stars++;
            }
            current_number_of_line++;
        }
    }
}
