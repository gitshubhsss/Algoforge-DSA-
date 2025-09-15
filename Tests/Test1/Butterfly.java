package Tests.Test1;

import java.util.Scanner;

public class Butterfly {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total_number_of_lines = n;
        int spaces = n - 2;
        int stars = 1;
        int current_number_of_lines = 1;
        while (current_number_of_lines <= total_number_of_lines) {
            // print stars
            for (int i = 1; i <= stars; i++) {
                System.out.print("*");
            }
            // print spaces
            for (int i = 1; i <= spaces; i++) {
                System.out.print(" ");
            }
            if (current_number_of_lines == n / 2 + 1) {
                // if it is a middle line then
                stars--;
            }
            // prints stars
            for (int i = 1; i <= stars; i++) {
                System.out.print("*");
            }
            // prepare for the next line
            if (current_number_of_lines <= n / 2) {
                stars++;
                spaces = spaces - 2;
            } else if (current_number_of_lines == n / 2 + 1) {
                // reset the stars
                stars = n / 2;
                spaces = 1;
            } else {
                stars--;
                spaces = spaces + 2;
            }
            current_number_of_lines++;
            System.out.println();
        }

        sc.close();
    }
}
