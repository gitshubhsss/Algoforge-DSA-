import java.util.Scanner;

public class Main {

    public static int findDecimal(int num) {
        int dec = 0;
        int currentBase = 1; // 2 ki power 0=1;
        while (num > 0) {
            int lastNum = num % 10;
            dec = dec + currentBase * lastNum;
            num = num / 10;
            currentBase = currentBase * 2;
        }
        return dec;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the binary number ");
        int binary = sc.nextInt();
        int dec = findDecimal(binary);
        System.out.println(dec);
    }
}