

public class Contest {

    public static String majorityFrequencyGroup(String s) {

        // aaabbbccdddde
        int count = 1;
        for (int i = 0; i < s.length(); i++) {

            char currentChar = s.charAt(i);
            count = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == currentChar) {
                    count++;
                }
            }
            System.out.println(count);

        }

        return "";
    }

    public static void main(String[] args) {
        String str = "aaabbbccdddde";

        majorityFrequencyGroup(str);
    }
}
