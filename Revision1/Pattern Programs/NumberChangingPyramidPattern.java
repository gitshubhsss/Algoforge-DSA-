import java.util.Scanner;

public class NumberChangingPyramidPattern {
    public static void main(String[] args) {
        System.out.println("Enter the value of n");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int total_number_of_lines = n;

        int stars = n;

        int current_number_of_lines = 1;

        while (current_number_of_lines <= total_number_of_lines) {

            for (int i = 1; i <= stars; i++) {
                System.out.print(i + " ");
            }
            stars--;
            current_number_of_lines++;
            System.out.println();
        }
    }
}
