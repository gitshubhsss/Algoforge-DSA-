import java.util.Scanner;

public class DownwordTrianglePattern {
    public static void main(String[] args) {
        System.out.println("Enter the total number of lines");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int total_number_lines = n;
        int current_number_of_line = 1;

        int stars = n;

        while (current_number_of_line <= total_number_lines) {
            // print stars

            for (int i = 1; i <= stars; i++) {
                System.out.print("* ");
            }

            // prepare for the next line
            stars--;
            current_number_of_line++;
            System.out.println();

        }
    }
}

// * * * * *
// * * * *
// * * *
// * *
// *