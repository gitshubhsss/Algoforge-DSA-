public class ConvertLettersToAppositeCase {

    public static String convertToAppositeCase(String str) {

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                // covert to lower case
                // If we wants to go from Uppercase to lower case we add +32 in the
                ans.append((char) (ch + ('a' - 'A')));

                // 91-65=32
                // 32+65=97 ('a'-'A')+A So A A will be cancel remains a=97
                // 32+66=98 ('a'-'A')+B so B=A+1 so A A will be canele reamins a+1 which is

            } else {
                // Convert to uppercase
                // if we wants to go from lowercase to uppser case we subtracg -32
                ans.append((char) (ch + ('A' - 'a')));
                // 65-97=-32
                // -32+97=65 ie 'a' to 'A'
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String str = "ABcdEfgH";
        System.out.println(convertToAppositeCase(str));
    }
}
