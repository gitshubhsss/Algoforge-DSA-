import java.util.Scanner;

public class RightAngledNumberPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of lines : ");
        int total_number_of_lines = sc.nextInt();

        // Starting line
        int line = 1;

        while (line <= total_number_of_lines) {

            // Print the numbers for 1 to till line

            for (int i = 1; i <= line; i++) {
                System.out.print(i + " ");
            }

            // Prepare for the next line
            System.out.println();
            line++;

        }

    }
}

// 1 
// 1 2
// 1 2 3
// 1 2 3 4
// 1 2 3 4 5