import java.util.ArrayList;

public class KeyPadCombinations {
    static String[] lettersArray = { ",:", "<;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static ArrayList<String> getKeyPadCombinations(String str) {
        // base case
        if (str.length() == 0) {
            ArrayList<String> baseArrayList = new ArrayList<>();
            baseArrayList.add("");
            return baseArrayList;
        }
        // means if hte string is 345 then the smaller string will be 45
        String smallerStr = str.substring(1);
        ArrayList<String> smallerAns = getKeyPadCombinations(smallerStr);
        ArrayList<String> myAns = new ArrayList<>();

        // todo finding the letter index form teh letterarray
        int letterIndex = str.charAt(0) - '0';
        String letters = lettersArray[letterIndex];

        // going on the each letter
        for (int i = 0; i < letters.length(); i++) {
            char currentChar = letters.charAt(i);
            for (String s : smallerAns) {
                // Adding char to the string from the smaller ans
                myAns.add(currentChar + s);
            }
        }
        return myAns;

    }

    public static void main(String[] args) {

        String str = "48";
        System.out.println(getKeyPadCombinations(str));

    }
}
