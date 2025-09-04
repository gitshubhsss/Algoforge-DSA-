import java.util.Scanner;

public class Pattern7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of stars");
        int n = sc.nextInt();

        int total_number_of_lines = n/2+1;
        int current_number_of_lines = 1;
        int stars = 1;
        int spaces = n/2;

        while (current_number_of_lines <= total_number_of_lines) {
            // print spaces
            for (int i = 1; i <= spaces; i++) {
                System.out.print("  ");
            }
            // print stars
            for (int i = 1; i <= stars; i++) {
                if (i == 1 || i == stars || current_number_of_lines == total_number_of_lines) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            // prepare for the next line
            spaces--;
            stars=stars+2;
            current_number_of_lines++;
            System.out.println();
        }
    }
}
//9
//         * 
//       *   *
//     *       *
//   *           *
// * * * * * * * * *