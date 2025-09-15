package Tests.Test1;

import java.util.Scanner;

public class SumOfEvenPostion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int num = sc.nextInt();

        // Find the length
        int temp = num;
        int len = 0;
        while (temp > 0) {
            temp = temp / 10;
            len++;
        }
        int sum = 0;
        while (num > 0) {
            int last = num % 10;
            if (len % 2 == 0) {
                sum = sum + last;
            }
            num = num / 10;
            len--;
        }
        System.out.println(sum);

        sc.close();
    }
}
