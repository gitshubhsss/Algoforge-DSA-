import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();

        int ans = 0;
        if (n <= 1) {
            ans = 0;
        } else {
            int l = 1;
            int sl = 0;
            for (int i = 2; i <= n; i++) {
                int current = l + sl;
                sl = l;
                l = current;
            }
            System.out.println(l);
        }
    }
}
