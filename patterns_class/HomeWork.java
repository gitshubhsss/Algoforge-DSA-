import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of lines");

        int n = sc.nextInt();
        int total_number_of_lines = n;

        int spaces = (n * 2 - 1) - 2;

        int stars = 1;

        int current_number_of_line = 1;

        while (current_number_of_line <= total_number_of_lines) {

            int num = 1;
            // print stars
            for (int i = 1; i <= stars; i++) {
                System.out.print(num);
                num++;
            }
            num--;
            // print spaces
            for (int i = 1; i <= spaces; i++) {
                System.out.print(" ");
            }

            if (current_number_of_line == total_number_of_lines) {
                stars = stars - 1;
                num--;
            }
            // print stars
            for (int i = 1; i <= stars; i++) {
                System.out.print(num);
                num--;
            }
            // preprare for the next line
            System.out.println();
            stars++;
            spaces = spaces - 2;
            current_number_of_line++;
        }
    }
}
