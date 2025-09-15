import java.util.Scanner;

public class FibonacciPatter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number lines");
        int n = sc.nextInt();
        int total_number_of_lines = n;
        int current_number_of_line = 1;
        int currentNum = 1;
        int lastNum = 1;
        int secondLastNum = 0;
        int star = 1;

        while (current_number_of_line <= total_number_of_lines) {
            // print the numbers

            for (int i = 1; i <= star; i++) {
                System.out.print(currentNum + " ");
                currentNum = lastNum + secondLastNum;
                secondLastNum = lastNum;
                lastNum = currentNum;
            }
            // Prepare for the next line
            System.out.println();
            current_number_of_line++;
            star++;
        }
        sc.close();
    }
}
