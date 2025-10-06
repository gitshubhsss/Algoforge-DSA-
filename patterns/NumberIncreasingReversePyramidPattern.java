import java.util.Scanner;

public class NumberIncreasingReversePyramidPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n = sc.nextInt();
        int num = n;
        int total_number_lines = n;
        int current_number_of_line = 1;

        while (current_number_of_line <= total_number_lines) {
            // print the numebers from 1 to num

            for (int i = 1; i <= num; i++) {
                System.out.print(i + " ");
            }

            // prepare for hte next line
            System.out.println();
            num--;
            current_number_of_line++;
        }
    }
}
