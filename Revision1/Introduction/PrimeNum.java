import java.util.Scanner;

public class PrimeNum {
    public static void main(String[] args) {

        System.out.println("Enter the number");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int factorCount = 0;

        // approch
        // 1==============================================================================

        // for (int i = 1; i <= n; i++) {
        // if (n % i == 0) {
        // factorCount++;
        // }

        // }
        // if (factorCount == 2) {
        // System.out.println("Number is prime number");
        // } else {
        // System.out.println("Number is not a prime number");
        // }

        // Approch 2
        // ============================================================================
        // using the math.sqrt fuction

        boolean isPrime = true;

        // for (int i = 2; i <= Math.sqrt(n); i++) {
        // if (n % i == 0) {
        // isPrime=false;
        // }
        // }

        // we can take the square on the both side
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                isPrime = false;
            }
        }

        if (isPrime) {
            System.out.println("Number is prime number");
        } else {
            System.out.println("Number is not prime");
        }

    }
}
