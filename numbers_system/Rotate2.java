import java.util.Scanner;

public class Rotate2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take the number from the user
        System.out.println("Enter the number");
        int num = sc.nextInt();

        // Take the value of k from the user

        System.out.println("Enter the value of k : ");
        int k = sc.nextInt();

        int numLength = 0;

        // Storing the value of num to temp
        int temp = num;

        // find the lenth of the number
        while (num > 0) {
            num = num / 10;
            numLength++;
        }

        k = k % numLength;
        if (k < 0) {
            k = k + numLength;
        }

        // find the last digits

        int lastDigits = temp % (int) Math.pow(10, k);// 45
        int remainingDigits = temp / (int) Math.pow(10, numLength - k - 1);

        int ans = lastDigits * (int) Math.pow(10, numLength - k) + remainingDigits;
        System.out.println(ans);

    }
}
