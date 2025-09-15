import java.util.Scanner;

public class DiagonalPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of lines");

        int n = sc.nextInt();

        int total_number_of_lines = n;

        int current_number_of_line = 1;

        int stars = 1;
        int outerSpaces = n / 2;
        int innerSpace = -1;

        while (current_number_of_line <= total_number_of_lines) {
            // Print outer space
            for (int i = 1; i <= outerSpaces; i++) {
                System.out.print(" ");
            }
            // print stars
            for (int i = 1; i <= stars; i++) {
                System.out.print("*");
            }
            // Print inner space
            for (int i = 1; i <= innerSpace; i++) {
                System.out.print(" ");
            }
            // print stars
            if (current_number_of_line != 1 && current_number_of_line != n) {
                for (int i = 1; i <= stars; i++) {
                    System.out.print("*");
                }
            }

            // prepare for the next line
            System.out.println();
            if (current_number_of_line <= n / 2) {
                outerSpaces--;
                innerSpace = innerSpace + 2;

            } else {
                outerSpaces++;
                innerSpace = innerSpace - 2;
            }
            current_number_of_line++;
        }
         sc.close();

    }
}
