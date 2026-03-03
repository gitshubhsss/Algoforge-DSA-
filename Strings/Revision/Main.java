public class Main {

    public static String compressString(String str) {

        char prev = str.charAt(0);

        String ans = prev + "";

        for (int i = 1; i < str.length(); i++) {

            char curr = str.charAt(i);

            if (curr != prev) {
                ans = ans + curr;
            }

            prev = curr;
        }
        return ans;
    }

    // aabccddddeeffzzaaa
    public static String compressStringWithCount(String str) {

        String ans = str.charAt(0) + "";

        char prev = str.charAt(0);

        int count = 1;
        //
        for (int i = 1; i < str.length(); i++) {

            char curr = str.charAt(i);

            if (curr == prev) {
                count++;// 2

            } else {
                if (count > 1) {

                    //add the count
                    ans = ans + count;
                    //set count to 0
                    count = 1;
                    //add the current
                    ans = ans + curr;
                }

            }
            prev = curr;
        }

        if (count > 1) {
            ans = ans + count;
        }

        return ans;

    }

    public static void main(String[] args) {

        String str = "aabccddddeeffzzaaa";
        System.out.println(compressStringWithCount(str));
    }
}