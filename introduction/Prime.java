import java.util.*;

public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        
        boolean isPrime = true;

        // i <= Math.sqrt((double) n)= i*i <=n;

        for (int i = 2; i * i <= n; i++) {// We have taken the sqaure of both the sides
            if (n % i == 0) {
                isPrime = false;
            }
        }

        if (isPrime == true) {
            System.out.println("Prime number");
        } else {
            System.out.println("Not a prime number");
        }
    }
}
