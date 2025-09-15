import java.util.Scanner;

public class Butterfly {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of stars");
        int n = sc.nextInt();
        int total_number_lines = n;
        int spaces = n - 2;
        int stars = 1;
        int current_number_of_line = 1;
        while (current_number_of_line <= total_number_lines) {
            // print stars
            for (int i = 1; i <= stars; i++) {
                System.out.print("* ");
            }
            // print spaces
            for (int i = 1; i <= spaces; i++) {
                System.out.print("  ");
            }

            if (current_number_of_line == n / 2 + 1) {
                stars--;
            }

            // print stars
            for (int i = 1; i <= stars; i++) {
                System.out.print("* ");
            }
            // prepare for the next line
            if (current_number_of_line <= n / 2) {
                spaces = spaces - 2;
                stars++;
            } else if (current_number_of_line == n / 2 + 1) {
                stars = n / 2;// resign the stars
                spaces = 1;
            } else {
                stars--;
                spaces = spaces + 2;
            }
            current_number_of_line++;
            System.out.println();
        }
         sc.close();

    }
}
