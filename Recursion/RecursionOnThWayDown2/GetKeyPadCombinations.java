import java.util.ArrayList;

public class GetKeyPadCombinations {

    public static String[] lettersArray = { "abc", "def", "ghi", "lkm", "nop", "qurs", "twu", "vxyz" };

    // str=01
    public static ArrayList<String> getKeyPadCom(String str) {

        if (str.length() == 0) {
            // return the arryalist with empty string
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        // faith:it will work properly for the smaller value
        // the smaller string will be str.substring(1)
        String smallStr = str.substring(1);

        ArrayList<String> smallerAns = getKeyPadCom(smallStr);
        // Smaller ans contains the answer return by the smaller value lets say 1 return
        // the def okay now i have to make the my ans and add it to the smaller ans
        ArrayList<String> myAns = new ArrayList<>();
        int letterIndex = str.charAt(0) - '0';
        if (letterIndex >= lettersArray.length) {
            ArrayList<String> baseAnsToReturn = new ArrayList<>();
            return baseAnsToReturn;
        }
        String letters = lettersArray[letterIndex];
        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);
            for (String s : smallerAns) {
                myAns.add(ch + s);
            }
        }
        return myAns;

    }

    public static void main(String[] args) {
        String keyPadNums = "01";

        System.out.println(getKeyPadCom(keyPadNums));

    }
}