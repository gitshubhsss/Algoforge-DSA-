import java.util.Scanner;

public class RightAngledNumberPyramid2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of lines");
        int total_number_of_lines = sc.nextInt();
        int line = 1;

        while (line <= total_number_of_lines) {

            // print the line number from 1 to till line number

            for (int i = 1; i <= line; i++) {
                System.out.print(line);
            }

            // Prepare for the next line
            System.out.println();
            line++;
        }
    }
}

// 1
// 22
// 333
// 4444
// 55555
