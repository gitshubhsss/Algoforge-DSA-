import java.util.Scanner;

public class DiagonalStarPattern {

    public static void main(String[] args) {
        System.out.println("Enter the value of n");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total_number_of_lines = n;

        int current_number_of_lines = 1;

        while (current_number_of_lines <= total_number_of_lines) {

            for (int i = 1; i <= n; i++) {
                if (i == 1 || current_number_of_lines == 1 || current_number_of_lines == n || i == n
                        || (i == current_number_of_lines) || (i + current_number_of_lines == n + 1)) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }

            }

            // prepare for the next line
            current_number_of_lines++;
            System.out.println("");
        }
    }
}
