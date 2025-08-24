import java.util.Scanner;

public class SumOfEvenFibonacciNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int range = sc.nextInt();

        int sum = 0;// to store the some of even numbers
        int sLast = 0;
        int last = 1;
        for (int i = 2; i <= range; i++) {
            int current = sLast + last;
            sLast = last;
            last = current;

            if (current % 2 == 0) {
                sum = sum + current;
            }
        }

        System.out.println("sum of even numbers is = " + sum);

    }
}
