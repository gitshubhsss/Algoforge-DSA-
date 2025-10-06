import java.util.Scanner;

public class HollowPyramidPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n = sc.nextInt();

        int total_number_lines = n;
        int current_number_of_line = 1;
        int stars = 1;
        int space = n / 2;
        while (current_number_of_line <= total_number_lines) {
            // print space
            for (int i = 1; i <= space; i++) {
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
            if (current_number_of_line < n / 2) {
                stars += 2;
                space--;
            } else {
                stars -= 2;
                space++;
            }
            current_number_of_line++;
            System.out.println();
        }
        sc.close();
    }
}
