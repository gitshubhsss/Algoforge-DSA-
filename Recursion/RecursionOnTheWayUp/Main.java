
public class Main {

    public static void printSubSequences(String str, String ssf) {
        if (str.length() == 0) {
            System.out.println(ssf);
            return;
        }

        char firstChar = str.charAt(0);
        String smallestString = str.substring(1);
        printSubSequences(smallestString, ssf);
        printSubSequences(smallestString, ssf + firstChar);
    }

    static String[] lettersArray = { ",:", "<;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    // 47
    public static void printKeypadCombinations(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }
        String smallStr = str.substring(1);
        int firstDigit = str.charAt(0) - '0';
        String letters = lettersArray[firstDigit];

        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            printKeypadCombinations(smallStr, asf + letter);
        }

        // Write your code here

    }

    public static void printStairPath(int n, String asf) {
        if (n < 0) {
            return;
        }
        if (n == 0) {
            System.out.println(asf);
            return;
        }
        printStairPath(n - 1, asf + 1);
        printStairPath(n - 2, asf + 2);
        printStairPath(n - 3, asf + 3);
    }

    public static void printMazePathWithJumps(int sr, int sc, int dr, int dc, String psf) {

        if (sr > dr || sc > dc) {
            return;
        }
        if (sc == dc && sr == dr) {
            System.out.println(psf);
            return;
        }

        // horizontal jumps
        for (int jump = 1; jump <= dc - sc; jump++) {
            printMazePathWithJumps(sr, sc + jump, dr, dc, psf + "h" + jump);
        }

        // vertical jumps
        for (int jump = 1; jump <= dr - sr; jump++) {
            printMazePathWithJumps(sr + jump, sc, dr, dc, psf + "v" + jump);
        }

        // dialgonal path
        // matlab hum check kar rahe hai
        for (int jump = 1; jump < Math.min(dr - sr, dc - sc); jump++) {
            printMazePathWithJumps(sr + jump, sc + jump, dr, dc, psf + "d" + jump);
        }

    }

    public static char digitToChar(int digit) {
        return (char) ((digit - 1) + 'a');
    }

    public static void printEndcoding(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        int firstDigit = str.charAt(0) - '0';

        // not a valid answer
        if (firstDigit == 0) {
            return;
        }
        char cChar = digitToChar(firstDigit);
        String smallStr = str.substring(1);
        printEndcoding(smallStr, cChar + asf);

    }

    // Yes no call
    public static void printTargetSumSubsets(int arr[], int idx, int tar, String asf) {
        // negative target found
        if (tar < 0) {
            return;
        }

        // target has become 0 that means we have got the path
        if (idx == arr.length) {
            if (tar == 0) {
                System.out.println(asf);
            }
            return;
        }

        // yes call
        printTargetSumSubsets(arr, idx + 1, tar - arr[idx], asf + arr[idx]);

        // no call
        printTargetSumSubsets(arr, idx + 1, tar, asf);
    }

    public static void main(String args[]) {
        // printSubSequences("abc", "");
        // printKeypadCombinations("84", "");

        // printStairPath(4, "");
        // printMazePathWithJumps(0, 0, 2, 2, "");

        int arr[] = { 2, 5, 3, 1, 4, 6, -8 };

        int tar = 8;

        printTargetSumSubsets(arr, 0, tar, "");

    }
}