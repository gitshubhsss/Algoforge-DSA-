import java.util.Scanner;

public class SpacesPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        int total_number_of_lines = n;
        int current_number_of_line = 1;
        int spaces = 0;
        int stars = n;

        while (current_number_of_line <= total_number_of_lines) {
            // print space
            for (int i = 1; i <= spaces; i++) {
                System.out.print("  ");
            }
            // print stars
            for (int i = 1; i <= stars; i++) {
                if (current_number_of_line != 1 && current_number_of_line <= n / 2 && i != 1 && i != stars) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }
            // prepare for the next line
            System.out.println();
            if (current_number_of_line <= n / 2) {
                spaces++;
                stars = stars - 2;
            } else {
                spaces--;
                stars = stars + 2;
            }
            current_number_of_line++;
        }
    }
}
