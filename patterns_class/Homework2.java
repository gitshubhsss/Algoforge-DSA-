import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n = sc.nextInt();
        int total_number_of_lines = n * 2 + 1;
        int current_number_of_line = 1;
        int stars = 1;
        int spaces = n;
        int number = 1;
        while (current_number_of_line <= total_number_of_lines) {
            // print spaces
            for (int i = 1; i <= spaces; i++) {
                System.out.print("  ");
            }
            // pringt stars

            int tempNum = number;
            for (int i = 1; i <= stars; i++) {
                System.out.print(tempNum + " ");

                if (i <= stars / 2) {
                    tempNum++;
                } else {
                    tempNum--;
                }
            }

            // prepare for the next line
            System.out.println();
            if (current_number_of_line <= n) {
                number++;
                stars = stars + 2;
                spaces--;
            } else {
                number--;
                stars = stars - 2;
                spaces++;
            }
            current_number_of_line++;

        }
        sc.close();
    }
}
