
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int secondLast = 0;
        int last = 1;

        for (int i = 1; i <= n; i++) {
            // since it starts with 0 will print the secondLast first
            System.out.println(secondLast);
            int current = secondLast + last;
            secondLast = last;
            last = current;
        }
    }
}
