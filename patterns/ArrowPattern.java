import java.util.Scanner;

public class ArrowPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the n");
        int n = sc.nextInt();

        int spaces = n / 2;
        int star = 1;

        int total_number_of_lines = n;
        int current_number_of_line = 1;
        while (current_number_of_line <= total_number_of_lines) {

            if (current_number_of_line == n / 2 + 1) {
                // print all the stars
                for (int i = 1; i <= n; i++) {
                    System.out.print("* ");
                }
                star = star - 1;
            } else {
                // print spaces
                for (int i = 1; i <= spaces; i++) {
                    System.out.print("  ");
                }
                // print stars
                for (int i = 1; i <= star; i++) {
                    System.out.print("* ");
                }

                // prepare for the next line

                if (current_number_of_line <= n / 2) {
                    star++;
                } else {
                    star--;
                }

            }

            System.out.println();
            current_number_of_line++;

        }
        sc.close();
    }
}

//n=5
//     * 
//     * * 
// * * * * * 
//     * * 
//     * 
