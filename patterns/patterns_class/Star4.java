import java.util.Scanner;

public class Star4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of lines");
        int n = sc.nextInt();
        int total_number_of_lines = n * 2 + 1;
        int current_number_of_line = 1;
        // initial spaces and stars
        int spaces = n;
        int stars = 1;
        while (current_number_of_line <= total_number_of_lines) {
            // print spaces
            for (int i = 1; i <= spaces; i++) {
                System.out.print(" ");
            }
            // print stars
            for (int i = 1; i <= stars; i++) {
                System.out.print("*");
            }
            // prepare for the next line
            if (current_number_of_line > n) {
                spaces++;
                stars = stars - 2;
            } else {
                spaces--;
                stars = stars + 2;
            }
            current_number_of_line++;
            System.out.println();
        }
        sc.close();

    }
}
