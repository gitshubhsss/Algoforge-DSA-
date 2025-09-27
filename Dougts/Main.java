import java.util.Scanner;

public class Main {

    public static int convertToBinaryNum(int num) {
        return -1;
    }

    // 10
    // 1010
    public static int convertToDecimalNum(int num) {

        // initialize the dec variable
        int dec = 0;

        // find the last dight of the num
        int base = 0;
        while (num > 0) {
            // find the last dight of the num
           
            int lastDigit = num % 10;
            dec = dec + currentBase * lastDigit;
            num = num / 10;
            
        }
        return dec;
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the number");
        // int num = sc.nextInt();

        System.out.println(convertToDecimalNum(1010));

    }
}