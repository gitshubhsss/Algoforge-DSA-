import java.util.Scanner;

public class RotateNumByK {
    public static void main(String[] args) {
        int num = 12345;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of k");
        int k = sc.nextInt();
        int n = 0;

        int temp = num;
        while (temp > 0) {
            temp = temp / 10;
            n++;
        }
        System.out.println("length " + n);
        k = k % n;
        if (k < 0) {
            k = k + n;
        }

        // find the remder
        // 12345
        int rem = num % (int) Math.pow(10, k);// last digits 1000
        System.out.println(rem + "rem");
        int div = num / (int) Math.pow(10, k);// first digit 
        System.out.println(div + "div");
        int ans = rem * (int) Math.pow(10, n - k) + div;
        System.out.println(ans);

    }
}
