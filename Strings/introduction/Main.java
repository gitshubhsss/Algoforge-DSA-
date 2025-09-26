public class Main {

    // aabbbbcdexx
    public static String compressString2(String str) {
        String ans = "";
        ans = ans + str.charAt(0);
        char prev = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == prev) {
                count++;// 2
            } else {
                if (count > 1) {
                    ans = ans + count;
                }
                ans = ans + curr;
                count = 1;
            }
            prev = curr;

        }
        if (count > 1) {
            ans = ans + count;
        }
        return ans;

    }

    public static String compressString(String str) {
        String ans = "";
        ans = ans + str.charAt(0);
        char prev = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr != prev) {
                ans = ans + curr;
            }
            prev = curr;
        }
        return ans;
    }

    public static String convertAsci(String str) {

        StringBuilder subString = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            char currChar = str.charAt(i);

            if (currChar >= 'A' && currChar <= 'Z') {// Upper case
                subString.append((char));
            } else if (currChar >= 'a' && currChar <= 'z') {// lower case
                subString.append((char) (currChar + 32));
            }
        }
        return subString.toString();
    }

    public static void main(String args[]) {
        String str1 = "AbcdeFg";
        String str2 = "aabccddddeeffzzaa";
        System.out.println(convertAsci(str2));
        ;

        // StringBuilder sb = new StringBuilder();
        // sb.append("shubham");
        // sb.append("shivaji");
        // sb.append('s');

        // sb.reverse();
        // System.out.println(sb);

        // a2bc2d4f2z2a2
        // System.out.println(compressString2(str));

        // output abcdefza
    }
}