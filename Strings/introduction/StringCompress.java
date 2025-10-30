public class StringCompress {

    public static int compress(char[] chars) {
        int length = -1;
        String ans = "";
        char prev = chars[0];
        ans += prev;
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            char curr = chars[i];
            if (curr == prev) {
                count++;
            } else {
                if (count > 1) {
                    ans += count;
                    count = 1;
                }
                ans += curr;
            }
            prev = curr;
        }
        if (count > 1) {
            ans += count;
        }
        System.out.println(ans);
        return ans.length();
    }

    public static void main(String[] args) {
        char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };

        System.out.println(compress(chars));
    }
}
