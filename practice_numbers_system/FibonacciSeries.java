package practice_numbers_system;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the range ");
        int n = sc.nextInt();

        int secondLastNum = 0;
        int lastNum = 1;

        for (int i = 1; i <= n; i++) {
            System.out.print(secondLastNum + " ");
            int current = secondLastNum + lastNum;
            secondLastNum = lastNum;
            lastNum = current;
        }
        System.out.println();
        System.out.println(secondLastNum);
    }
}

// Enter the range
// 8
// 0 1 1 2 3 5 8 13
