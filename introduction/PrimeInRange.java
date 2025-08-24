import java.util.Scanner;

public class PrimeInRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the range");
        int range = sc.nextInt();

        for (int num = 2; num <= range; num++) {

            // Will print the prime numbers from 1 to n

            boolean isPrime = true;

            // i*i<=num === i<=squre root of n
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime == true) {
                System.out.println(num);
            }
        }
    }
}
