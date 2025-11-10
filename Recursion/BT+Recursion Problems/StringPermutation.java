import java.util.*;

public class StringPermutation {

    public static List<List<String>> getPermutations(String str) {

        if (str.length() == 0) {
            List<String> baseAns = new ArrayList<>();
            baseAns.add("");
            List<List<String>> ans = new ArrayList<>();
            ans.add(baseAns);
            return ans;
        }

        List<List<String>> myAns = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {

            char currChar = str.charAt(i);
            String leftString = str.substring(0, i);
            String rightString = str.substring(i + 1);

            List<List<String>> smallAns = getPermutations(leftString + rightString);

            for (List<String> letters : smallAns) {

                List<String> myList = new ArrayList<>();

                for (String letter : letters) {
                    myList.add(currChar + "," + letter);
                }

                myAns.add(myList);

            }

        }

        return myAns;
    }

    public static void main(String[] args) {

        String str = "abc";

        System.out.println(getPermutations(str));
    }
}
