public class Main {

    public static void printDecreasing(int n) {

        if (n <= 0) {
            return;
        }

        System.out.println(n);

        printDecreasing(n - 1);
    }

    public static void printIncreasing(int n) {

        if (n <= 0) {
            return;
        }

        printIncreasing(n - 1);

        System.out.println(n);
    }

    public static void printIncDec(int n) {

        if (n <= 0) {
            return;
        }

        System.out.println(n);

        printIncDec(n - 1);

        if (n > 1) {
            System.out.println(n);
        }
    }

    public static int findFact(int n) {

        if (n <= 0) {
            return 1;
        }

        int smallerAns = findFact(n - 1);

        int ans = smallerAns * n;

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

    public static int findPowWithLogN(int x, int y) {

        if (y <= 0) {
            return 1;
        }

        int smallerAns = findPowWithLogN(x, y / 2);

        int ans = smallerAns * smallerAns;

        if (y % 2 == 1) {
            ans = ans * x;
        }

        return ans;

    }

    // Moving the n disc from a to c using b
    public static void toh(int n, int A, int B, int C) {

        if (n <= 0) {
            return;
        }

        // move the disc from A TO B using C
        toh(n - 1, A, C, B);
        System.out.println("Moving " + n + " th " + " disk from " + A + " to " + C);
        // move the disc from B to C using A
        toh(n - 1, B, A, C);

    }

    // count steps of tower of honoi
    public static int tohSteps(int n, int A, int B, int C) {

        if (n <= 0) {
            return 0;
        }

        int stepsToMoveAtoB = tohSteps(n - 1, A, C, B);
      
        int stepsToMoveBtoC = tohSteps(n - 1, B, A, C);
  
        int totalSteps = stepsToMoveAtoB + stepsToMoveBtoC+1;

        return totalSteps;
    }

    public static void main(String[] args) {
        // printDecreasing(5);
        // printIncreasing(4);
        // printIncDec(5);

        // System.out.println(findFact(5));

        // System.out.println(findPow(2, 6));

        // System.out.println(findPowWithLogN(2, 6));
        // toh(2, 10, 20, 30);
        System.out.println(tohSteps(2, 10, 20, 30));
    }
}