import java.util.Scanner;

public class Pattern3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        int total_number_of_lines = n;
        int current_of_lines = 1;
        int stars = 1;
        int spaces = (n * 2) - 3;

        while (current_of_lines <= total_number_of_lines) {
            int num = 1;
            // print stars
            for (int i = 1; i <= stars; i++) {
                System.out.print(num + " ");
                num++;
            }
            // last line ko num-2 karenge
            if (current_of_lines == total_number_of_lines) {
                num = num - 2;
            } else {
                num--;
            }

            // print spaces
            for (int i = 1; i <= spaces; i++) {
                System.out.print("  ");
            }
            // print stars
            if (current_of_lines == total_number_of_lines) {
                stars--;
            }

            for (int i = 1; i <= stars; i++) {
                System.out.print(num + " ");
                num--;
            }
            // preparation for the next line
            current_of_lines++;
            spaces = spaces - 2;
            stars++;
            System.out.println();
        }
    }
}

// 1                       1 
// 1 2                   2 1 
// 1 2 3               3 2 1 
// 1 2 3 4           4 3 2 1 
// 1 2 3 4 5       5 4 3 2 1 
// 1 2 3 4 5 6   6 5 4 3 2 1 
// 1 2 3 4 5 6 7 6 5 4 3 2 1
