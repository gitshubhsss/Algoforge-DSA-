import java.util.Scanner;

public class PrimeRange {

    public static boolean isPrime(int n) {

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Enter the range");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // if n== 10 2.3,5,7

        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }

    }
}
