public class CompressString {

    public static String compressString(String str) {
        String ans = "";
        // Initialize the pointers
        // prev will be the first charcater of the string
        char prev = str.charAt(0);
        ans = ans + prev;
     
        // the initial anser will look like a only a now will have a loop from the
        // the first index and will compare the current char with prev if they are not
        // equal
        // then and then only will add the curretn char in the answer

        for (int i = 1; i < str.length(); i++) {
            // take the current char
            char currentCharacter = str.charAt(i);

            // if they are not equal then only assign it in the string
            if (currentCharacter == prev) {
                continue;
            } else {
                ans = ans + currentCharacter;
                //
            }
            // as we are going forward change the previous character value as well
            prev = currentCharacter;
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "aabccddddeeffzzaa";
        // The output should be abcdefza

        System.out.println(compressString(str));

    }
}
