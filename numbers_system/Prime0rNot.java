import java.util.Scanner;

public class Prime0rNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int number = sc.nextInt();
        int count = 0;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                count++;
            }
            if (count == 2) {
                break;
            }
        }
        if (number == 1) {
            System.out.println("Not a prime number");
        } else if (count == 0) {
            System.out.println("Prime number");
        } else {
            System.out.println("Not a prime number");
        }

    }
}
