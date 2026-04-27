import java.util.Scanner;

public class HollowHourglassPattern {
    public static void main(String[] args) {
        System.out.println("Enter the total number of lines");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int total_number_of_lines = n * 2 - 1;

        int current_number_of_lines = 1;
        int stars = 1;
        int spaces = n - 1;

        while (current_number_of_lines <= total_number_of_lines) {
            // print space
            for (int i = 1; i <= spaces; i++) {
                System.out.print("  ");
            }
            // print stars
            for (int i = 1; i <= stars; i++) {
                if (i == 1 || i == stars) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            // prepare for the next line
            if (current_number_of_lines < n) {
                spaces--;
                stars += 2;
            } else {
                spaces++;
                stars -= 2;
            }

            current_number_of_lines++;
            System.out.println();
        }

    }
}
// *
// * *
// * *
// * *
// * *
// * *
// * *
// * *
// * *
// * *
// *