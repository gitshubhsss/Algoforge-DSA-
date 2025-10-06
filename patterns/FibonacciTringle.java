import java.util.Scanner;

public class FibonacciTringle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n = sc.nextInt();

        int last = 1;
        int sl = 0;

        int total_number_lines = n;
        int current_number_of_line = 1;
        while (current_number_of_line <= total_number_lines) {

            for (int i = 1; i <= current_number_of_line; i++) {
                System.out.print(last + " ");
                int current = last + sl;
                sl = last;
                last = current;
            }
            current_number_of_line++;
            System.out.println();
        }
    }
}
