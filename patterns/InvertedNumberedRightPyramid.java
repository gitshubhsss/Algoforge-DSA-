import java.util.Scanner;

public class InvertedNumberedRightPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of lines");

        int n = sc.nextInt();
        int row = 1;
        int total_numbers_to_be_print = n;

        while (row <= n) {
            // print total numbers to be print

            for (int i = 1; i <= total_numbers_to_be_print; i++) {
                System.out.print(i);
            }

            // prepare for the next line
            System.out.println();

            total_numbers_to_be_print--;
            row++;
        }
    }
}

// 12345
// 1234
// 123
// 12
// 1
