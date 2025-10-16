public class Main {

    public static void printIncresingDecreasing(int n) {
        if (n <= 0) {
            return;
        }
        System.out.println(n);
        printIncresingDecreasing(n - 1);
        if (n > 1) {
            System.out.println(n);
        }
    }

    // funtion to print the numbers from 1 to n
    public static void printNumbersFrom1toN(int n) {
        if (n <= 0) {
            return;
        }
        printNumbersFrom1toN(n - 1); // it will print the numbers from 1 to n-1
        System.out.println(n);
    }

    // funtion to print the numbers from n to 1 n=5
    public static void printNumbersFromNto1(int n) {
        if (n <= 0) {
            return;
        }
        System.out.println(n);
        // faith it will print 4 to 1
        printNumbersFromNto1(n - 1);
    }

    // funtion to find the factorial of a number

    public static int findFact(int n) {
        if (n <= 1) {
            return 1;
        }
        int smallerAns = findFact(n - 1);
        int finalAns = n * smallerAns;
        return finalAns;
    }

    // 8456
    public static int reverseNum(int n) {
        if (n <= 0) {
            return 0;
        }
        int digitLength = 0;
        int temp = n;
        while (temp > 0) {
            temp = temp / 10;
            digitLength++;
        }
        int reverse = 0;
        int smallNum = n % (int) Math.pow(10, digitLength - 1);
        System.out.println(smallNum);
        reverseNum(smallNum);
        while (n > 0) {
            int rem = n % 10;
            reverse = reverse * 10 + rem;
            n = n / 10;
        }
        return reverse;

    }
    // 8

    public static void main(String[] args) {
        // printNumbersFromNto1(5);
        // printNumbersFrom1toN(5);
        // printIncresingDecreasing(5);

        // System.out.println(findFact(4));

        System.out.println(reverseNum(8425));
    }
}