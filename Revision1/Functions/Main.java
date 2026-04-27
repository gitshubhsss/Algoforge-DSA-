
public class Main {

    public static int findDecimal(int binaryNum) {
        // to conver the binary to decimal
        // 1010 -> so imagine it as 2^0 | 2^1 | 2^2 | 2^3

        int decimalNum = 0;
        int pow = 0;
        while (binaryNum > 0) {
            int lastDigit = binaryNum % 10;
            decimalNum = decimalNum + (int) Math.pow(2, pow) * lastDigit;
            binaryNum = binaryNum / 10;
            pow++;
        }
        return decimalNum;

    }

    public static int findBinary(int decimalNum) {
        int binaryNum = 0;
        int pow = 0;

        while (decimalNum > 0) {
            // take a module with 2
            int rem = decimalNum % 2;
            binaryNum = binaryNum + (int) Math.pow(10, pow) * rem;
            pow++;
            decimalNum = decimalNum / 2;// keep deviding it with 2
        }
        return binaryNum;

    }

    public static void main(String[] args) {
        // int num = 1010;// 10;
        // System.out.println(findDecimal(num));
        int num = 10;
        System.out.println(findBinary(num));
    }
}
