import java.util.Scanner;

public class Pattern6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n = sc.nextInt();
        int total_number_of_lines = n * 2 - 1;
        int spaces = n * 2 - 3;
        int current_number_of_line = 1;
        int stars = 1;
        while (current_number_of_line <= total_number_of_lines) {
            // print stars

            int num = 1;
            for (int i = 1; i <= stars; i++) {
                System.out.print(num + " ");
                if (num == 1) {
                    num = 0;
                } else {
                    num = 1;
                }
            }
            num = 1;
            // print space
            for (int i = 1; i <= spaces; i++) {
                System.out.print("  ");
            }

            // do some logic for hte middle elevemet
            if (current_number_of_line == n) {
                stars--;
                num = 0;
            }
            // print stars
            for (int i = 1; i <= stars; i++) {
                System.out.print(num + " ");
                if (num == 1) {
                    num = 0;
                } else {
                    num = 1;
                }
            }
            // prepare for the next line
            if (current_number_of_line < n) {
                stars++;
                spaces = spaces - 2;
            } else if (current_number_of_line == n) {
                stars = n - 1;
                spaces = 1;

            } else {
                stars--;
                spaces = spaces + 2;
            }

            current_number_of_line++;
            System.out.println();
        }
        sc.close();
    }
}

// 7
// 1                       1 
// 1 0                   1 0
// 1 0 1               1 0 1
// 1 0 1 0           1 0 1 0
// 1 0 1 0 1       1 0 1 0 1
// 1 0 1 0 1 0   1 0 1 0 1 0
// 1 0 1 0 1 0 1 0 1 0 1 0 1 
// 1 0 1 0 1 0   1 0 1 0 1 0
// 1 0 1 0 1       1 0 1 0 1
// 1 0 1 0           1 0 1 0
// 1 0 1               1 0 1
// 1 0                   1 0
// 1                       1
