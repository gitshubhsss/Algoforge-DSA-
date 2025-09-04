import java.util.Scanner;

public class NumberOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int num = sc.nextInt();

        // String numstring = String.valueOf(num);
        int count = 0;
        while (num > 0) {
        count++;
        num = num / 10;
        }

        // System.out.println(numstring.length());

        System.out.println("Total number of digits are " + count);
    }
}
