public class Main {

    // Define the function what is expected from the function
    public static void printDec(int num) {

        // base case
        // represents the smaller problem
        if (num <= 0) {
            return;
        }
        System.out.println(num);

        // Assume that the function works for the sammlae value
        printDec(num - 1);
        return;

    }

    public static void printIncresing(int n) {
        // base case
        if (n == 0) {
            return;
        }
        // Assume that it works for n-1
        printIncresing(n - 1);
        // print n
        System.out.println(n);
        // return
        return;
    }

    public static void printIncreseDecrease(int n) {
        // base case
        if (n == 1) {
            System.out.println(n);
            return;
        }
        // print decresing
        System.out.println(n);
        printIncreseDecrease(n - 1);

        // print incresing

        System.out.println(n);

        return;
    }

    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        int smallestAns = fact(n - 1);
        int ans = n * smallestAns;
        return ans;
    }

    public static int findPower(int x, int y) {
        if (y == 0) {
            return 1;
        }
        int smallestPow = findPower(x, y - 1);
        int ans = x * smallestPow;
        return ans;
    }

    public static int findPower2(int x, int y) {
        if (y == 0) {
            return 1;
        }
        int smallerAns = findPower2(x, y / 2);
        int ans = smallerAns * smallerAns;
        if (y % 2 == 1) {
            ans = ans + ans;
        }
        return ans;
    }

    public static int sum(int n) {

        if (n == 0) {
            return 0;
        }
        int smallerAns = sum(n - 1);
        int ans = n + smallerAns;
        return ans;
    }

    public static void printArr(int arr[], int index) {
        if (index > arr.length - 1) {
            return;
        }
        System.out.println(arr[index]);
        printArr(arr, index + 1);
    }

    public static void main(String[] args) {
        // printDec(5);
        // printIncreseDecrease(5);
        // System.out.println(fact(4));

        // System.out.println(findPower2(2, 6));
        // System.out.println(sum(5));

        int arr[] = { 1, 2, 3, 4 };
        printArr(arr, 0);

    }
}