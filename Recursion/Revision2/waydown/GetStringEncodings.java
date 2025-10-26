
package waydown;

import java.util.*;

public class GetStringEncodings {

    public static char convertToChar(int n) {
        return (char) (('a' - (1 - n)));
    }

    public static ArrayList<String> getStringEncoding(String str) {

        if (str.length() == 0) {
            ArrayList<String> baseAns = new ArrayList<String>();
            baseAns.add("");
            return baseAns;
        }

        String smallerString = str.substring(1);

        ArrayList<String> smallerAns = getStringEncoding(smallerString);

        int firstDigit = str.charAt(0) - '0';

        char firstChar = convertToChar(firstDigit);

        ArrayList<String> myAns = new ArrayList<>();

        for (String s : smallerAns) {
            myAns.add(firstChar + s);
        }

        if (str.length() >= 2) {

            smallerString = str.substring(2);

            String leftString = str.substring(0, 2);

            if (Integer.parseInt(leftString) <= 26) {

                smallerAns = getStringEncoding(smallerString);

                firstChar = convertToChar(Integer.parseInt(leftString));

                for (String s : smallerAns) {
                    myAns.add(firstChar + s);
                }
            }
        }

        return myAns;

    }

    public static void main(String args[]) {
        System.out.println(getStringEncoding("123"));
    }
}
