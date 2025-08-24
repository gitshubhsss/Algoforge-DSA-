import java.util.Scanner;

public class FibonacciInRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the range");
        int range = sc.nextInt();

        // We already know the second last element and the last element
        int sLast = 0;
        int last = 1;

        // Print the second last and last element

        for (int i = 2; i < range; i++) {
            int current = sLast + last;
            sLast = last;
            last = current;

        }
        System.out.println(last);

    }
}
