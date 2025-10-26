package waydown;

import java.util.ArrayList;

class possibleWords {

    public static String[] lettersArray = { "", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

    public static ArrayList<String> possibleWordsCom(int[] arr) {
        // code here

        return getCombinations(arr, 0);

    }

    // 0, "","pqrs"
    // 2,3=abc,def==>ad,ae,af,bd,be,bf,cd,ce,cf

    public static ArrayList<String> getCombinations(int[] arr, int idx) {

        if (idx == arr.length) {
            ArrayList<String> baseAns = new ArrayList<String>();
            baseAns.add("");
            return baseAns;
        }

        ArrayList<String> smallerAns = getCombinations(arr, idx + 1);

        int letterIdx = arr[idx];

        String letters = lettersArray[letterIdx];

        ArrayList<String> myAns = new ArrayList<String>();

        if (letters.isEmpty()) {
            return smallerAns;
        }

        for (int i = 0; i < letters.length(); i++) {

            char letter = letters.charAt(i);

            for (String s : smallerAns) {
                myAns.add(letter + s);
            }

        }
        return myAns;
    }

    public static void main(String args[]) {

        int arr[] = { 0, 7 };
        System.out.println(possibleWordsCom(arr));
    }

}