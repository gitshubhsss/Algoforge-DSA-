import java.util.Scanner;

public class HolloDiamondPattern {
    public static void main(String[] args) {

        System.out.println("Enter the value of n");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int total_number_of_lines = n;
        int current_number_of_lines = 1;
        int spaces = n - 1;
        int stars = 1;

        while (current_number_of_lines <= total_number_of_lines) {

            // print the outer spaces
            for (int i = 1; i <= spaces; i++) {
                System.out.print("  ");
            }

            for (int i = 1; i <= stars; i++) {
                // print fist and the last star
                if (i == 1 || i == stars) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }

            // prepare for the next line
            current_number_of_lines++;// 2//3
            spaces--;// 4//3
            stars += 2;// 5
            System.out.println();

        }

        // print the last row
        for (int i = 1; i <= stars - 2; i++) {
            System.out.print("# ");
        }

        sc.close();
    }
}

// Input: n=6
// #
// # #
// # #
// # #
// # #
// # #
// ###########