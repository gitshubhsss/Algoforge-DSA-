import java.util.Scanner;

public class FibonacciPattern {
    public static void main(String[] args) {
        System.out.println("Enter the value of n");

        Scanner sc = new Scanner(System.in);

        int total_number_of_lines = sc.nextInt();

        int current_number_of_lines = 1;

        int secondLast = 1;
        int last = 1;

        int stars = 1;

        while (current_number_of_lines <= total_number_of_lines) {

            for (int i = 1; i <= stars; i++) {
                System.out.print(secondLast + " ");
                int current = secondLast + last;
                secondLast = last;
                last = current;
            }

            System.out.println();
            current_number_of_lines++;
            stars++;
        }

    }
}
