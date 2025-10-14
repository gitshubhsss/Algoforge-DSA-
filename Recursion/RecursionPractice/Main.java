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

    public static int reverseNum(int n) {

        if (n == 0) {
            return 0;
        }
        int rem = n % 10;
        int reverse = 0;
        int smallrev = reverseNum(n - 1);
        reverse = reverse * 10 + rem;
        return smallrev;
    }

    public static void main(String[] args) {
        // printNumbersFromNto1(5);
        // printNumbersFrom1toN(5);
        // printIncresingDecreasing(5);

        // System.out.println(findFact(4));

        System.out.println(reverseNum(8425));
    }
}