import java.util.Scanner;

public class InverseOfNum {
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int pos = 1;
        int inverseNum = 0;

        while (n > 0) {
            int lastNum = n % 10;
            inverseNum = inverseNum + (int) (Math.pow(10, lastNum - 1)) * pos;
            n = n / 10;
            pos++;

        }

        System.out.println(inverseNum);
    }
}
