package basics;

public class Main {

    // print 1 to n numbers
    public static void printAsc(int n) {
        if (n <= 0) {
            return;
        }
        printAsc(n - 1);
        System.out.println(n);
    }

    // print n to 1
    public static void printDec(int n) {
        if (n <= 0) {
            return;
        }
        System.out.println(n);
        printDec(n - 1);
    }

    // print the numbers from n to 1 then 1 to n
    public static void printDecAsc(int n) {
        if (n <= 0) {
            return;
        }

        System.out.println(n);
        printDecAsc(n - 1);
        if (n > 1) {
            System.out.println(n);
        }
    }

    public static int findFactorial(int n) {

        if (n <= 0) {
            return 1;
        }
        int smallerAns = findFactorial(n - 1);
        int ans = n * smallerAns;
        return ans;
    }

    public static int findPow(int x, int y) {
        if (y <= 0) {
            return 1;
        }
        int smallerAns = findPow(x, y - 1);
        int ans = smallerAns * x;
        return ans;
    }

    public static int findPowWithBinaryOptimization(int x, int y) {

        if (y <= 0) {
            return 1;
        }
        int smallerAns = findPowWithBinaryOptimization(x, y / 2);
        int ans = smallerAns * smallerAns;
        if (y % 2 == 1) {
            ans = ans * x;
        }
        return ans;
    }

    public static void printZigZic(int n) {

        if (n <= 0) {
            return;
        }

        System.out.print(n);
        printZigZic(n - 1);
        System.out.print(n);
        printZigZic(n - 1);
        System.out.print(n);
    }

    public static void main(String[] args) {
        // printAsc(5);
        // printDec(5);
        // printDecAsc(5);
        // int fact = findFactorial(5);
        // System.out.println(fact);

        // int x = 2;
        // int y = 5;
        // int ans = findPow(x, y);
        // System.out.println(ans);

        // int ans = findPowWithBinaryOptimization(x, y);
        // System.out.println(ans);

        printZigZic(3);

    }
}
