import java.util.ArrayList;

public class Question {

    public static ArrayList<String> getSubsequences(String str) {
        if (str.length() == 0) {
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        char firstChar = str.charAt(0);
        ArrayList<String> smallerAns = getSubsequences(str.substring(1));

        ArrayList<String> myAns = new ArrayList<>();

        // a says no
        for (String s : smallerAns) {
            myAns.add(s);
        }

        // a says yes
        for (String s : smallerAns) {
            myAns.add(firstChar + s);
        }

        return myAns;
    }

    static String[] lettersArray = { ",:", "<;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static ArrayList<String> getKeypadCombinations(String str) {
        // return the base ans
        if (str.length() == 0) {
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        ArrayList<String> smallerAns = getKeypadCombinations(str.substring(1));

        ArrayList<String> myAns = new ArrayList<>();

        int firstDigit = str.charAt(0) - '0'; // '8' - '0' = 8;
        String letters = lettersArray[firstDigit];

        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            for (String s : smallerAns) {
                myAns.add(letter + s);
            }
        }
        return myAns;
    }

    public static ArrayList<String> getStairsPath(int n) {

        if (n < 0) {
            return new ArrayList<>();
        }

        if (n == 0) {
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        ArrayList<String> pathsAfterOneStep = getStairsPath(n - 1);
        ArrayList<String> pathsAfterTwoStep = getStairsPath(n - 2);
        ArrayList<String> pathsAfterThreeStep = getStairsPath(n - 3);

        ArrayList<String> allPaths = new ArrayList<>();

        for (String path : pathsAfterOneStep) {
            allPaths.add("1" + path);
        }

        for (String path : pathsAfterTwoStep) {
            allPaths.add("2" + path);
        }

        for (String path : pathsAfterThreeStep) {
            allPaths.add("3" + path);
        }

        return allPaths;

    }

    public static ArrayList<String> getMazePath(int sr, int sc, int dr, int dc) {

        if (sr > dr || sc > dc) {
            return new ArrayList<>();
        }

        if (sc == dc && sr == dr) {
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        ArrayList<String> horizontalPath = getMazePath(sr, sc + 1, dr, dc);

        ArrayList<String> verticalPath = getMazePath(sr + 1, sc, dr, dc);

        ArrayList<String> myAns = new ArrayList<>();

        for (String s : horizontalPath) {
            myAns.add("h" + s);
        }

        for (String s : verticalPath) {
            myAns.add("v" + s);
        }

        return myAns;
    }

    public static void main(String[] args) {
        // System.out.println(getSubsequences("abc"));
        // System.out.println(getKeypadCombinations("23"));
        // System.out.println(getStairsPath(4));

        System.out.println(getMazePath(0, 0, 2, 2));
    }
}
