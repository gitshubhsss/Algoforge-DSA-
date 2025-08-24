import java.util.Scanner;

public class CheckFibonacciNumberOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int number = sc.nextInt();

        if (number == 0 || number == 1) {
            System.out.println("Number " + number + " is in Fibonacci series");
            return; // exit early
        }
        boolean isInRange = false;
        int sLast = 0;
        int last = 1;

        // for (int i = 1; i <= number; i++) {
        // int current = sLast + last;
        // sLast = last;
        // last = current;
        // if (last == number) {
        // isInRange = true;
        // break;
        // }
        // if (last > number) {
        // break;
        // }
        // }

        while (last <= number) {
            int current = sLast + last;
            sLast = last;
            last = current;
            if (last == number) {
                isInRange = true;
                break;
            }
        }

        if (isInRange == true) {
            System.out.println("Number " + number + " is in range");
        } else {
            System.out.println("Number " + number + " is not in range");
        }

    }
}
