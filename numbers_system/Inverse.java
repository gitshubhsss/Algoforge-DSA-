import java.util.Scanner;

public class Inverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        int pos = 1;
        int inverse = 0;

        while (n > 0) {
            int last = n % 10;
            inverse = inverse + (int) Math.pow(10, last - 1) * pos;
            pos++;
            n = n / 10;
        }

        System.out.println(inverse);
    }
}
