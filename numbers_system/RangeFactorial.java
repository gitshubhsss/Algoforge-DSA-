import java.util.Scanner;

public class RangeFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = scanner.nextInt();

        for (int num = 2; num <= n; num++) {

            // Now check for every number till n
            boolean isPrime = false;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(num);
            }
        }
    }
}
