import java.util.Scanner;

public class Pattern8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n = sc.nextInt();
        int total_number_of_lines = n;
        int stars = n;
        int current_number_of_line = 1;
        int space = 0;

        while (current_number_of_line <= total_number_of_lines) {
            // print spaces
            for (int i = 1; i <= space; i++) {
                System.out.print("  ");
            }
            // print stars
            for (int i = 1; i <= stars; i++) {
                if ((current_number_of_line != 1 && current_number_of_line != n) && (i != stars
                        && i != 1) && (current_number_of_line <= n / 2)) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }
            // prepare for the next lin

            if (current_number_of_line <= n / 2) {
                space++;// 1
                stars = stars - 2;// 3
            } else {
                space--;
                stars = stars + 2;
            }
            current_number_of_line++;// 2
            System.out.println();
        }
    }
}
