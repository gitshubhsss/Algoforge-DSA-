import java.util.Scanner;

public class SpacesPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        int total_number_of_lines = n;
        int current_number_of_line = 1;
        int spaces = 1;
        int stars = n / 2 + 1;
        int count = 1;

        while (current_number_of_line <= total_number_of_lines) {

            int num = count;
            // print stars
            for (int i = 1; i <= stars; i++) {
                System.out.print(num + " ");
                num++;
            }
            num--;
            // print spaces
            for (int i = 1; i <= spaces; i++) {
                System.out.print("  ");
            }
            // print stars
            for (int i = 1; i <= stars; i++) {
                System.out.print(num + " ");
                num--;
            }
            // prepare for the next line
            if (current_number_of_line <= n / 2) {
                spaces = spaces + 2;
                stars--;
                count++;
            } else {
                stars++;
                spaces = spaces - 2;
                count--;
            }
            current_number_of_line++;
            System.out.println();
        }
         sc.close();

    }
}

// 5
// 1 2 3   3 2 1 
// 2 3       3 2
// 3           3
// 2 3       3 2
// 1 2 3   3 2 1
