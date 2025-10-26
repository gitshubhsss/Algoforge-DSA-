package waydown;

import java.util.ArrayList;

public class Main {

    public static ArrayList<String> getSubSequences(String str) {

        if (str.length() == 0) {
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        String smallerString = str.substring(1);

        ArrayList<String> smallerAns = getSubSequences(smallerString);

        char firstChar = str.charAt(0);

        ArrayList<String> myAns = new ArrayList<>();

        // first char say no
        for (String s : smallerAns) {
            myAns.add(s);
        }

        // first char say yes
        for (String s : smallerAns) {
            myAns.add(firstChar + s);
        }

        return myAns;

    }

    public static ArrayList<String> getClimbPath(int n) {

        if (n < 0) {
            return new ArrayList<>();
        }

        if (n == 0) {
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        ArrayList<String> pathAfterOneStep = getClimbPath(n - 1);

        ArrayList<String> pathAfterTwoSteps = getClimbPath(n - 2);

        ArrayList<String> pathAfterThreeSteps = getClimbPath(n - 3);

        ArrayList<String> myAns = new ArrayList<>();

        // n=7 steps=6
        // we have taken n-1 step only 1 step has remain to reach the destination
        for (String s : pathAfterOneStep) {
            myAns.add("1" + s);
        }

        // n=7 steps=5
        // we have taken n-2 step only 2 step has remain to reach the destination
        for (String s : pathAfterTwoSteps) {
            myAns.add("2" + s);
        }

        // n=7 steps=4
        // we have taken n-3 step only 3 step has remain to reach the destination
        for (String s : pathAfterThreeSteps) {
            myAns.add("3" + s);
        }

        return myAns;

    }

    public static ArrayList<String> getMazePath(int sr, int sc, int er, int ec) {

        if (sc > ec || sr > er) {
            return new ArrayList<>();
        }

        if (sc == ec && sr == er) {
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        ArrayList<String> horizontalPaths = getMazePath(sr, sc + 1, er, ec);
        ArrayList<String> verticalPaths = getMazePath(sr + 1, sc, er, ec);

        ArrayList<String> myAns = new ArrayList<>();

        // add h to horizontal path
        for (String s : horizontalPaths) {
            myAns.add("h" + s);
        }

        // add v to vertical path
        for (String s : verticalPaths) {
            myAns.add("v" + s);
        }

        return myAns;

    }

    public static ArrayList<String> getMazePathWithJumpsAllowed(int sr, int sc, int dr, int dc) {

        if (sc > dc || sr > dr) {
            return new ArrayList<>();
        }

        if (sc == dc && sr == dr) {
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        ArrayList<String> myAns = new ArrayList<>();

        // horizontal jumps
        for (int jump = 1; jump <= dc - sc; jump++) {

            ArrayList<String> horizontalPath = getMazePathWithJumpsAllowed(sr, jump + sc, dr, dc);

            for (String s : horizontalPath) {
                myAns.add("h" + jump + s);
            }
        }

        // vertical jumps

        for (int jump = 1; jump <= dr - sr; jump++) {

            ArrayList<String> verticalPath = getMazePathWithJumpsAllowed(jump + sr, sc, dr, dc);

            for (String s : verticalPath) {
                myAns.add("v" + jump + s);
            }
        }

        return myAns;

    }

    public static void main(String[] args) {
        // System.out.println(getSubSequences("abc"));

        // System.out.println(getClimbPath(4));
        //System.out.println(getMazePath(0, 0, 2, 2));//[hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]
        System.out.println(getMazePathWithJumpsAllowed(0, 0, 2, 2));

    }
}
