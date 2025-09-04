import java.util.Scanner;

public class Pattern2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();

        int total_number_lines = n;
        int current_number_of_line = 1;
        int stars = n;
        int spaces = 0;

        while (current_number_of_line <= total_number_lines) {
            // print spaces
            for (int i = 1; i <= spaces; i++) {
                System.out.print("  ");
            }
            // print stars
            for (int i = 1; i <= stars; i++) {
                if (current_number_of_line != 1 && i != 1 && i != stars
                        && current_number_of_line <= n / 2) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }
            // preparation for the next lin
            if (current_number_of_line <= n / 2) {
                stars = stars - 2;
                spaces++;
            } else {
                stars = stars + 2;
                spaces--;
            }
            current_number_of_line++;
            System.out.println();
        }
    }
}


// * * * * * 
//   *   *
//     *
//   * * *
// * * * * *