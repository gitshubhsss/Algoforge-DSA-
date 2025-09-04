package practice_numbers_system;

import java.util.Scanner;

public class CheckFibonacciNumberOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int number = sc.nextInt();

        int secondLastNum = 0;
        int lastNum = 1;

        boolean isFibo = false;

        while (lastNum <= number) {
            int current = secondLastNum + lastNum;
            secondLastNum = lastNum;
            lastNum = current;
            if (lastNum == number) {
                isFibo = true;
                break;
            }
        }
        System.out.println(isFibo);
    }
}
