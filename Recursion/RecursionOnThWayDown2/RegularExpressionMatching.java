public class RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {

        if (s.length() == 0) {
            return true;
        }
        String smallStr = s.substring(1);
        // faith it will work properly for idx+1 to n-1
        boolean smallMatch = isMatch(smallStr, p);

        char sChar = s.charAt(0);
        int pCharIndex = s.length() - 1;
        char pChar = ' ';
        if (p.length() >= s.length()) {
            pChar = p.charAt(pCharIndex);
            System.out.println("p char is "+pChar);
        }
        boolean isStarOrDotContains = (sChar == pChar) || (pChar == '.' || pChar == '*');
        if (smallMatch == true && isStarOrDotContains == true) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a*"));
    }
}
