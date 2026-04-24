import java.util.Scanner;

public class CountDIgits {
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int digitCount = 0;

        while (n > 0) {
            n = n / 10;
            System.out.println(n);
            digitCount++;

        }

        System.out.println("Total number of digit inside the " + n + " is " + digitCount);
    }
}
