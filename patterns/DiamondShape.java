import java.util.*;

public class DiamondShape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n = sc.nextInt();

        int total_number_of_lines = n * 2;
        int current_number_of_line = 1;

        int space = n - 1;
        int stars = 1;

        System.out.println("spaces = " + space);
        System.out.println("stars = " + stars);

        while (current_number_of_line <= total_number_of_lines) {

            // print spaces
            for (int i = 1; i <= space; i++) {
                System.out.print(" ");
            }
            // print stars
            for (int i = 1; i <= stars; i++) {
                System.out.print("*");
            }

            // prepare for the next line
            if (current_number_of_line < n) {
                space -= 1;
                stars += 2;
            } else {
                space += 1;
                stars -= 2;
            }
            current_number_of_line++;
            System.out.println();
        }
        sc.close();
    }
}
