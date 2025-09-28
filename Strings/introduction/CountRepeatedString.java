public class CountRepeatedString {

    public static String countDuplicates(String str) {
        String ans = "";
        // String str = "aabccddddeeffzzaa";
        char prev = str.charAt(0);// taking the previous character
        ans += prev;// storing it in the answer
        int n = str.length();
        int count = 1;
        // a2bccddddeeffzz
        for (int i = 1; i < n; i++) {
            // find the current charater
            char curr = str.charAt(i);
            if (curr == prev) {
                // if the current character == prev a==a simply increase the count
                // it will help us in knowing how many concecutive duplicates are their
                count++;// 2
            } else {
                if (count > 1) {
                    ans += count;
                }
                ans += curr;
                count = 1;
            }
            prev = curr;
        }
        if (count > 1) {
            ans += count;
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "aabccddddeeffzzaa";

        System.out.println(countDuplicates(str));
    }
}
