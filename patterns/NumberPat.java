import java.util.Scanner;

public class NumberPat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of lines");
        int n = sc.nextInt();
        int total_number_of_lines = n;
        int current_number_of_line = 1;
        int star = 1;
        int total_element_in_first_row = 2 * n - 1;
        int spaces = total_element_in_first_row - 2;

        while (current_number_of_line <= total_number_of_lines) {
            int num = 1;
            // print stars
            for (int i = 1; i <= star; i++) {
                System.out.print(num + " ");
                num++;
            }
            num--;

            // print spaces
            for (int i = 1; i <= spaces; i++) {
                System.out.print("  ");
            }
            // do some logic
            if (current_number_of_line == total_number_of_lines) {
                star--;
     
            }
            // print stars
            for (int i = 1; i <= star; i++) {
                System.out.print(num + " ");
                num--;
            }

            // prepare for the next line
            System.out.println();
            current_number_of_line++;
            star++;
            spaces = spaces - 2;
        }
    }
}


// Enter the number of lines
// 5
// 1               1 
// 1 2           2 1
// 1 2 3       3 2 1
// 1 2 3 4   4 3 2 1
// 1 2 3 4 5 5 4 3 2