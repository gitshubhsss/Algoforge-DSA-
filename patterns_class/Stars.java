import java.util.Scanner;

public class Stars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the total number of lines");

        int total_number_of_lines = sc.nextInt();

        // Stars in the first line
        int stars = total_number_of_lines;
        // starting row;
        int row = 1;

        while (row <= total_number_of_lines) {
            // Print stars

            for (int i = 1; i <= stars; i++) {
                System.out.print("*");
            }

            // prepare for the next line
            System.out.println();
            stars--;
            row++;
        }

    }
}
