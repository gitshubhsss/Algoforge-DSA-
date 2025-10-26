package wayup;

import java.util.ArrayList;

public class Main {

    public static void printSubsequence(String str, String asf) {

        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        String smallerStr = str.substring(1);

        char firstChar = str.charAt(0);

        // a say yes
        printSubsequence(smallerStr, asf + firstChar);
        // a says no
        printSubsequence(smallerStr, asf);
    }

    public static String[] lettersArray = { "", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

    // 2,3=>AD,AE,AF,BD,BE,BF,CD,CD,CF
    public static void printKeyPadCombinations(String str, String asf) {

        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        char firstChar = str.charAt(0);

        int letterIndex = firstChar - '0';

        String letters = lettersArray[letterIndex];

        String smallerString = str.substring(1);

        for (int i = 0; i < letters.length(); i++) {
            printKeyPadCombinations(smallerString, asf + letters.charAt(i));
        }

    }

    public static void printStairPath(int n, String asf) {

        if (n < 0) {
            return;
        }

        if (n == 0) {
            System.out.println(asf);
            return;
        }

        printStairPath(n - 1, asf + "1");
        printStairPath(n - 2, asf + "2");
        printStairPath(n - 3, asf + "3");

    }

    public static void printAllMazePath(int sr, int sc, int dr, int dc, String asf) {

        if (sr > dr || sc > dc) {
            return;
        }

        if (sc == dc && sr == dr) {
            System.out.println(asf);
            return;
        }

        // horizontal steps
        printAllMazePath(sr, sc + 1, dr, dc, asf + "h");

        // vertical steps
        printAllMazePath(sr + 1, sc, dr, dc, asf + "v");

    }

    public static void printAllMazePathWithJumps(int sr, int sc, int dr, int dc, String asf) {

        if (sc > dc || sr > dr) {
            return;
        }

        if (sc == dc && sr == dr) {
            System.out.println(asf);
            return;
        }

        // horizontal jumps
        for (int jump = 1; jump <= dc - sc; jump++) {
            printAllMazePathWithJumps(sr, jump + sc, dr, dc, asf + "h" + jump);
        }

        // vertical jumps
        for (int jump = 1; jump <= dr - sr; jump++) {
            printAllMazePathWithJumps(jump + sr, sc, dr, dc, asf + "v" + jump);
        }

        // diagonal jumps
        for (int jump = 1; jump <= Math.min((dc - sc), (dr - sr)); jump++) {

            printAllMazePathWithJumps(jump + sr, jump + sc, dr, dc, asf + "d" + jump);
        }
    }

    public static char convertToChar(int n) {
        return (char) (('a' - (1 - n)));
    }

    public static void printEncodings(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        String smallerString = str.substring(1);

        int firstDigit = str.charAt(0) - '0';

        if (firstDigit <= 0) {
            return;
        }

        char firstChar = convertToChar(firstDigit);

        printEncodings(smallerString, asf + firstChar);

        if (str.length() >= 2) {

            smallerString = str.substring(2);

            String leftString = str.substring(0, 2);

            if (Integer.parseInt(leftString) <= 26) {

                firstChar = convertToChar(Integer.parseInt(leftString));
                printEncodings(smallerString, asf + firstChar);

            }

        }

    }

    public static ArrayList<String> getStringPermutations(String str) {

        if (str.length() == 0) {
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        ArrayList<String> myAns = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char cChar = str.charAt(i);
            String leftString = str.substring(0, i);
            String righString = str.substring(i + 1);

            ArrayList<String> smallAns = getStringPermutations(leftString + righString);

            for (String s : smallAns) {
                myAns.add(cChar + s);
            }
        }

        return myAns;

    }

    public static void main(String[] args) {
        // printSubsequence("abc", "");
        // printKeyPadCombinations("23", "");

        // printStairPath(4, "");
        // printAllMazePath(0, 0, 2, 2, "");

        // printAllMazePathWithJumps(0, 0, 2, 2, "");

        // printEncodings("123", "");

        System.out.println(getStringPermutations("abc"));
    }
}
