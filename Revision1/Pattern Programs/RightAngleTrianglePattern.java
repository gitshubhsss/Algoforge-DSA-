import java.util.Scanner;

public class RightAngleTrianglePattern {
    public static void main(String[] args) {

        System.out.println("Enter the total number of lines");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int total_number_of_lines = n;
        int current_number_of_line = 1;

        int stars = 1;// stars in first line

        while (current_number_of_line <= total_number_of_lines) {
            // print stars
            for (int i = 1; i <= current_number_of_line; i++) {
                System.out.print("* ");
            }

            // prepare for the next line
            System.out.println();
            stars++;
            current_number_of_line++;
        }
    }
}

// *
// * *
// * * *
// * * * *
// * * * * *