public class CountRepeatedString {

    public static String countDuplicates(String str) {
        String ans = "";
        char prev = str.charAt(0);// taking the previous character
        ans += prev;// storing it in the answer
        int n = str.length();// Finding the length of the string
        int count = 1;// Means atleat the character will come atleast once
        for (int i = 1; i < n; i++) {
            // find the current charater
            char curr = str.charAt(i);
            if (curr == prev) {
                // if the current character == prev a==a simply increase the count
                // it will help us in knowing how many concecutive duplicates are their
                count++;// 2
            } else {
                // if Count is greater than 1 then add the count in the answer
                if (count > 1) {
                    ans += count;
                }
                // Add the current character
                ans += curr;
                // Make the counter to one to find the next concequtive elements
                count = 1;
            }
            prev = curr;
        }
        // Adding the last count if any
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
