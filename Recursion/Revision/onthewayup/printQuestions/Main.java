package onthewayup.printQuestions;

import java.util.ArrayList;

public class Main {

    public static void printSubSequences(String str, String asf) {
        if (str.length() <= 0) {
            System.out.println(asf);
            return;
        }
        String smallerString = str.substring(1);

        char firstChar = str.charAt(0);

        // a will say no
        printSubSequences(smallerString, asf);
        // a will say yes
        printSubSequences(smallerString, asf + firstChar);

    }

    static String[] lettersArray = { ",:", "<;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static void printKeyPadCombinations(String str, String asf) {

        if (str.length() == 0) {
            System.out.print(asf + " ");
            return;
        }

        int letterIndex = str.charAt(0) - '0';
        String letters = lettersArray[letterIndex];
        String smallerString = str.substring(1);
        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            printKeyPadCombinations(smallerString, asf + letter);
        }
    }

    public static void printStairPath(int n, String psf) {

        if (n < 0) {
            return;
        }
        if (n == 0) {
            System.out.println(psf);
            return;
        }

        printStairPath(n - 1, psf + "1");
        printStairPath(n - 2, psf + "2");
        printStairPath(n - 3, psf + "3");
    }

    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {

        if (sc > dc || sr > dr) {
            return;
        }
        if (sc == dc && sr == dr) {
            System.out.println(psf);
            return;
        }

        // horizontal path
        printMazePaths(sr, sc + 1, dr, dc, psf + "h");

        // vertical path
        printMazePaths(sr + 1, sc, dr, dc, psf + "v");
    }

    // All maze path with horizontal vertical diagonal
    public static void printMazePathWithJumps(int sr, int sc, int dr, int dc, String psf) {
        if (sc > dc || sr > dr) {
            return;
        }
        if (sc == dc && sr == dr) {
            System.out.println(psf);
            return;
        }

        // horizontal jumps
        int totalNumberOfHorizontalJumpsAllowed = dc - sc;
        for (int jump = 1; jump <= totalNumberOfHorizontalJumpsAllowed; jump++) {
            printMazePathWithJumps(sr, jump + sc, dr, dc, psf + "h" + jump);
        }

        // vertical jumps
        int totalNumberOfVerticalJumpsAllowed = dr - sr;
        for (int jump = 1; jump <= totalNumberOfVerticalJumpsAllowed; jump++) {
            printMazePathWithJumps(jump + sr, sc, dr, dc, psf + "v" + jump);
        }

        int totalDiagonalStepsAllowed = Math.min(totalNumberOfHorizontalJumpsAllowed,
                totalNumberOfVerticalJumpsAllowed);
        for (int jump = 1; jump <= totalDiagonalStepsAllowed; jump++) {
            printMazePathWithJumps(jump + sr, jump + sc, dr, dc, psf + "d" + jump);
        }

    }

    // function to convert the string into int
    public static int covertStringToInt(String str) {
        int num = Integer.parseInt(str);
        return num;
    }

    public static char digitToChar(int digit) {
        return (char) ((digit - 1) + 'a');
    }

    // TODO On the way up
    // Function to print the endcodings fo thte string
    public static void printEncodings(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }
        int firstDigit = str.charAt(0) - '0';
        if (firstDigit <= 0) {
            return;
        }
        char ch = digitToChar(firstDigit);
        String smallerString = str.substring(1);
        printEncodings(smallerString, asf + ch);

        if (str.length() >= 2) {
            String firstTwoChars = str.substring(0, 2);
            int firstTwoDigits = Integer.parseInt(firstTwoChars);
            if (firstTwoDigits <= 26) {
                ch = digitToChar(firstTwoDigits);
                smallerString = str.substring(2);
                printEncodings(smallerString, asf + ch);

            }
        }
    }

    // 123,1=a,2=b,3=c 12=l ,23=w
    // 123,23,3
    public static ArrayList<String> printEncodingsDown(String str) {
        if (str.length() <= 0) {
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }
        int firstDigit = str.charAt(0) - '0';// 1,2,3
        if (firstDigit <= 0) {
            return new ArrayList<>();
        }

        char ch = digitToChar(firstDigit);// a,b

        ArrayList<String> myAns = new ArrayList<>();

        String smallerString = str.substring(1);// 23,3,

        ArrayList<String> smallAns1 = printEncodingsDown(smallerString);
        for (String s : smallAns1) {
            myAns.add(ch + s);
        }
        // ["abc",]//123
        if (str.length() >= 2) {
            String firstTwoChars = str.substring(0, 2);
            int firstTwoDigits = Integer.parseInt(firstTwoChars);
            if (firstTwoDigits <= 26) {
                ch = digitToChar(firstTwoDigits);
                smallerString = str.substring(2);
                ArrayList<String> smallAns2 = printEncodingsDown(smallerString);
                for (String s : smallAns2) {
                    myAns.add(ch + s);
                }
            }
        }

        return myAns;

    }

    // Recursion on the way up
    public static void printPermutations(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char cChar = str.charAt(i);
            String leftSubString = str.substring(0, i);
            String rightSubString = str.substring(i + 1);
            printPermutations(leftSubString + rightSubString, asf + cChar);

        }
    }

    // Recursion on the way down
    public static ArrayList<String> getPermutationsDown(String str) {
        if (str.length() <= 0) {
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        ArrayList<String> myAns = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char cChar = str.charAt(i);
            String leftString = str.substring(0, i);
            String rightString = str.substring(i + 1);

            ArrayList<String> smallAns = getPermutationsDown(leftString + rightString);

            for (String s : smallAns) {
                myAns.add(cChar + s);
            }
        }
        return myAns;
    }

    public static int findMaxPathSum(int[][] grid, int row, int col) {

        if (row >= grid.length || col >= grid[0].length) {
            return Integer.MIN_VALUE;

        }
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col];
        }
        // find horizontal max

        int horizontalMax = findMaxPathSum(grid, row, col + 1);

        // find vertical max

        int verticalMax = findMaxPathSum(grid, row + 1, col);

        int ans = grid[row][col] + Math.max(horizontalMax, verticalMax);
        return ans;
    }

    public static void main(String[] args) {

        // printSubSequences("abc", "");
        // printKeyPadCombinations("23", "");
        // printStairPath(4, "");
        // printMazePaths(0, 0, 2, 2, "");
        // printMazePathWithJumps(0, 0, 2, 2, "");
        // printEncodings("123", "");
        // System.out.println(printEncodingsDown("123"));
        // printPermutations("bc", "");
        // System.out.println(getPermutationsDown("abc"));
        int grid[][] = { { 2, 3 }, { 4, 6 } };
        System.out.println(findMaxPathSum(grid, 0, 0));
    }
}
