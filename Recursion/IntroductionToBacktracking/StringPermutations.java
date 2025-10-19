import java.util.ArrayList;

public class StringPermutations {

    // On the way up
    public static void permutations(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            String leftString = str.substring(0, i);
            String rightString = str.substring(i + 1);
            String minimumString = leftString + rightString;
            permutations(minimumString, asf + currentChar);
        }
    }

    // on the way down
    public static ArrayList<String> permutationsStr(String str) {
        if (str.length() <= 0) {
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }
        ArrayList<String> myAns = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String leftString = str.substring(0, i);
            String rightString = str.substring(i + 1);
            ArrayList<String> smallerAns = permutationsStr(leftString + rightString);
            for (String s : smallerAns) {
                myAns.add(currChar + s);
            }
        }
        return myAns;
    }

    public static void main(String[] args) {
        String str = "abc";

       permutations(str, "");
       // System.out.println(permutationsStr(str));

    }
}

//[abc, acb, bac, bca, cab, cba]
// abc
// acb
// bac
// bca
// cab
// cba