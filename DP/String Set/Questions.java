import java.util.Arrays;

public class Questions {

    // Leetcode 647. Palindromic Substrings
    // https://leetcode.com/problems/palindromic-substrings/
    public int countSubstrings(String str) {
        int n = str.length();

        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int gap = 0; gap < str.length(); gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    dp[i][j] = str.charAt(i) == str.charAt(j);
                } else {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j]) {
                    // System.out.println(str.substring(i, j + 1));
                    count++;
                }
            }

        }

        return count;
    }

    /// Leetcode 5
    /// https://leetcode.com/problems/longest-palindromic-substring/submissions/1967011295/
    public String longestPalindrome(String str) {
        int n = str.length();

        boolean[][] dp = new boolean[n][n];
        int maxLength = 0;
        String ans = "";

        for (int gap = 0; gap < str.length(); gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    dp[i][j] = str.charAt(i) == str.charAt(j);
                } else {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && maxLength < (j - i) + 1) {
                    maxLength = (j - i) + 1;
                    ans = str.substring(i, j + 1);
                }
            }

        }

        return ans;
    }

    public static int longestPalindromeSubseq_rec(int si, int ei, String s) {

        if (si > ei) {
            return 0;
        }

        if (si == ei) {
            return 1;
        }

        int totalPal = 0;
        // yes call
        if (s.charAt(si) == s.charAt(ei)) {
            totalPal += longestPalindromeSubseq_rec(si + 1, ei - 1, s) + 2;
        } else {
            totalPal = Math.max(longestPalindromeSubseq_rec(si, ei - 1, s), longestPalindromeSubseq_rec(si + 1, ei, s));
        }

        return totalPal;

    }

    public static int longestPalindromeSubseq_memo(int si, int ei, String s, int[][] dp) {

        if (si > ei) {
            return 0;
        }

        if (si == ei) {
            return dp[si][ei] = 1;
        }

        if (dp[si][ei] != -1) {
            return dp[si][ei];
        }

        int totalPal = 0;
        // yes call
        if (s.charAt(si) == s.charAt(ei)) {
            totalPal += longestPalindromeSubseq_memo(si + 1, ei - 1, s, dp) + 2;
        } else {
            totalPal = Math.max(longestPalindromeSubseq_memo(si, ei - 1, s, dp),
                    longestPalindromeSubseq_memo(si + 1, ei, s, dp));
        }

        return dp[si][ei] = totalPal;

    }

    // Leetcode 516. Longest Palindromic Subsequence
    public int longestPalindromeSubseq(String s) {

        return -1;
    }

    // Leetcode : 115. Distinct Subsequences

    public static int numDistinct_rec(String s, String t, int n, int m) {

        return -1;
    }

    // 312. Burst Balloons
    public int burstBalloons_rec(int si, int ei, int n, int[] nums, int[][] dp) {
        if (dp[si][ei] != -1)
            return dp[si][ei];

        int leftValue = si == 0 ? 1 : nums[si - 1];
        int rightValue = ei == n - 1 ? 1 : nums[ei + 1];

        int maxCoins = 0;
        for (int cut = si; cut <= ei; cut++) {

            int left = cut == si ? 0 : burstBalloons_rec(si, cut - 1, n, nums, dp);
            int right = cut == ei ? 0 : burstBalloons_rec(cut + 1, ei, n, nums, dp);

            int curr = left + right + (leftValue * nums[cut] * rightValue);

            maxCoins = Math.max(maxCoins, curr);
        }

        return dp[si][ei] = maxCoins;
    }

    public int burstBalloons_tab(int n, int[] nums) {
        int[][] dp = new int[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int si = 0, ei = gap; ei < n; si++, ei++) {

                int leftValue = si == 0 ? 1 : nums[si - 1];
                int rightValue = ei == n - 1 ? 1 : nums[ei + 1];

                int maxCoins = 0;
                // What balloon should be burst at the end to get maximum coins
                for (int cut = si; cut <= ei; cut++) {
                    int left = cut == si ? 0 : dp[si][cut - 1]; // burstBalloons_rec(si, cut-1, n, nums, dp);
                    int right = cut == ei ? 0 : dp[cut + 1][ei]; // burstBalloons_rec(cut+1, ei, n, nums, dp);

                    int currAns = left + right + leftValue * nums[cut] * rightValue;
                    ;

                    maxCoins = Math.max(maxCoins, currAns);
                }

                dp[si][ei] = maxCoins;
            }
        }

        return dp[0][n - 1];
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        return burstBalloons_rec(0, n - 1, n, nums, dp);
    }

    /// 1547. Minimum Cost to Cut a Stick
    public int minCost_rec(int si, int ei, int stickLenght, int[] cuts, int[][] dp) {

        if (dp[si][ei] != -1) {
            return dp[si][ei];
        }

        int leftEnd = si == 0 ? 0 : cuts[si - 1];
        int rightEnd = ei == cuts.length ? stickLenght : cuts[ei + 1];

        int minCost = Integer.MIN_VALUE;
        for (int cut = si; cut <= ei; cut++) {

            int leftAns = cut == si + 1 ? 0 : minCost_rec(si, cut - 1, stickLenght, cuts, dp);
            int rightAns = cut == ei - 1 ? 0 : minCost_rec(cut + 1, ei, stickLenght, cuts, dp);

            int currAns = leftAns + rightAns + (cuts[ei] - cuts[si]);

            minCost = Math.min(minCost, currAns);
        }

        return dp[si][ei] = minCost;
    }

    public int minCost_tab(int[] cuts) {

        int n = cuts.length;
        int[][] dp = new int[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int si = 0, ei = gap; ei < n; si++, ei++) {

                if (ei - si <= 1) {
                    dp[si][ei] = 0;
                    continue;
                }

                int minCost = (int) 1e9;

                for (int cut = si + 1; cut < ei; cut++) {

                    int left = cut == si + 1 ? 0 : dp[si][cut];
                    int right = cut == ei - 1 ? 0 : dp[cut][ei];

                    int curr = left + right + (cuts[ei] - cuts[si]);

                    minCost = Math.min(minCost, curr);
                }

                dp[si][ei] = minCost;
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";

        // System.out.println(numDistinct(s, t));
    }
}
