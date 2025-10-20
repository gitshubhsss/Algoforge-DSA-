package getProblems;

import java.util.ArrayList;

public class Questions {

    public static ArrayList<String> getSubsequences(String str) {
        if (str.length() == 0) {
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        String smallerString = str.substring(1); // "bc"

        ArrayList<String> smallerAns = getSubsequences(smallerString);

        char firstChar = str.charAt(0);

        ArrayList<String> myAns = new ArrayList<>();
        // 'a' will say no
        for (String s : smallerAns) { // for(int i=0; i<smallerAns.size(); i++) String s = smallerAns.get(i)
            myAns.add(s);
        }

        // 'a' will say yes
        for (String s : smallerAns) { // for(int i=0; i<smallerAns.size(); i++) String s = smallerAns.get(i)
            myAns.add(firstChar + s);
        }

        return myAns;
    }

    static String[] lettersArray = { ",:", "<;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    // 2,4 ies abc,ghi =>ag,ah,ai,bg,bh,bi,cg,ch,ci
    public static ArrayList<String> getKeypadCombinations(String str) {

        if (str.length() == 0) {
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        String smallerString = str.substring(1);

        ArrayList<String> smallAns = getKeypadCombinations(smallerString);// "g,h,i"

        int firstDigit = str.charAt(0) - '0'; // '8' - '0' = 8;
        String letters = lettersArray[firstDigit];

        ArrayList<String> myAns = new ArrayList<>();

        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);

            for (String s : smallAns) {
                myAns.add(letter + s);
            }
        }

        return myAns;

    }

    // Get all path to to climb stairs
    public static ArrayList<String> getStairPaths(int n) {

        if (n < 0) {
            return new ArrayList<>();
        }

        if (n == 0) {
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        ArrayList<String> pathAfterOneStep = getStairPaths(n - 1);// 3=111,12,21,3
        ArrayList<String> pathAfterTwoStep = getStairPaths(n - 2);
        ArrayList<String> pathAfterThreeStep = getStairPaths(n - 3);

        ArrayList<String> myAns = new ArrayList<>();

        // add '1' to to n-1 means we have taken n-1 steps only 1 step is remaining
        // 3=111,12,21,3 so we go the answer will add the 1
        for (String s : pathAfterOneStep) {
            myAns.add("1" + s);
        }

        // add '2' to n-2 means we have taken n-2 steps only 2 steps are remains
        for (String s : pathAfterTwoStep) {
            myAns.add("2" + s);
        }

        // add '3' steps to n-3 means we have taken n-3 stpes only only 3 steps are
        // remaining

        for (String s : pathAfterThreeStep) {
            myAns.add("3" + s);
        }

        return myAns;

    }

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        if (sr > dr || sc > dc) {
            return new ArrayList<>();
        }
        if (sc == dc && sr == dr) {
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        ArrayList<String> horizontalPath = getMazePaths(sr, sc + 1, dr, dc);
        ArrayList<String> verticalPath = getMazePaths(sr + 1, sc, dr, dc);
        ArrayList<String> myAns = new ArrayList<>();

        for (String s : horizontalPath) {
            myAns.add("h" + s);
        }
        for (String s : verticalPath) {
            myAns.add("v" + s);
        }

        return myAns;

    }

    public static ArrayList<String> getMazePathsWithJumps(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        ArrayList<String> allPaths = new ArrayList<>();

        // horizontal jumps
        for (int jump = 1; jump <= dc - sc; jump++) {
            ArrayList<String> pathsAfterHJump = getMazePathsWithJumps(sr, sc + jump, dr, dc);

            for (String path : pathsAfterHJump) {
                allPaths.add("h" + jump + path);
            }
        }   

        // vertical jumps
        for (int jump = 1; jump <= dr - sr; jump++) {
            ArrayList<String> pathsAfterVJump = getMazePathsWithJumps(sr + jump, sc, dr, dc);

            for (String path : pathsAfterVJump) {
                allPaths.add("v" + jump + path);
            }
        }

        return allPaths;
    }

    public static void main(String[] args) {
        // String str = "abc";
        // System.out.println(getSubsequences(str));
        // System.out.println(getKeypadCombinations("24"));

        // System.out.println(getStairPaths(4));
        // System.out.println(getMazePaths(0, 0, 2, 3));
        System.out.println(getMazePathsWithJumps(0, 0, 3, 3));

    }
}
