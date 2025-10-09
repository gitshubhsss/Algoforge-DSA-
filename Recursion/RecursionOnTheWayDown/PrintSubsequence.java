import java.util.ArrayList;

public class PrintSubsequence {

    public static ArrayList<String> getSubSequence(String str) {
        if (str.length() == 0) {
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }
        String smallerString = str.substring(1);
        ArrayList<String> smallerAns = getSubSequence(smallerString);
        char firstChar = str.charAt(0);
        ArrayList<String> myAns = new ArrayList<>();
        for (String s : smallerAns) {
            myAns.add(s);
        }

        for (String s : smallerAns) {
            myAns.add(firstChar + s);
        }

        return myAns;
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(getSubSequence(str));
    }
}