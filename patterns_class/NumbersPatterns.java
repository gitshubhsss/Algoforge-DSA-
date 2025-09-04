import java.util.Scanner;

public class NumbersPatterns {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of lines");
        int n = sc.nextInt();
        int total_number_of_lines = n;

        int count = 1;

        int current_number_of_line = 1;

        while (current_number_of_line <= total_number_of_lines) {
            // print numbers
            for (int i = 1; i <= current_number_of_line; i++) {
                System.out.print(count + " ");
                count++;
            }
            // Prepare for the next line
            System.out.println();
            current_number_of_line++;
        }
    }
}
