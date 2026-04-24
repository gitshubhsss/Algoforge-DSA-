import java.util.Scanner;

public class RotateNum {
    public static void main(String[] args) {
        int num = 12345;

        System.out.println("Enter the value of k");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        int temp = num;
        int n = 0;

        while (temp > 0) {
            temp = temp / 10;
            n++;
        }

        k = k % n;
        if (k < 0) {
            k = k + n;
        }
        // 12345 =>345
        int rem = num % (int) Math.pow(10, k);
        System.out.println(rem);
        // 12345/1000=12
        int firstNdigit = num / (int) Math.pow(10, k);

        int ans = rem * (int) Math.pow(10, n - k) + firstNdigit;

        System.out.println(ans);

    }
}
