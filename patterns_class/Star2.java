import java.util.Scanner;

public class Star2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of lines");
        int n = sc.nextInt();
        int total_number_of_lines = n;
        int row = 1;

        // initial spaces and stars in the first line
        int spaces = n - 1;
        int stars = 1;

        while (row <= total_number_of_lines) {
            // print spaces
            for (int i = 1; i <= spaces; i++) {
                System.out.print(" ");
            }

            // print stars
            for (int i = 1; i <= stars; i++) {
                System.out.print("*");
            }

            // prepare for the next line
            System.out.println();
            spaces--;
            stars++;
            row++;
        }

    }
}
