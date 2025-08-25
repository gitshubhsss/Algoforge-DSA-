import java.util.Scanner;

public class BinaryNumberTrianglePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of lines");
        int total_number_lines = sc.nextInt();
        int row = 0;

        while (row < total_number_lines) {

            for (int col = 0; col <= row; col++) {

                // ROW=3
                if ((col == row) || (row % 2 == 0 && col % 2 == 0) || (row % 2 == 1 && col % 2 == 1)) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            // Prepare for the next line
            row++;
            System.out.println();
        }
    }
}

// 1
// 01
// 101
// 0101
// 10101
