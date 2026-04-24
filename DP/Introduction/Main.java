public class Main {

    // core resursion
    class Fibonacci {
        public static int fib_rec(int n) {
            if (n == 0 || n == 1) {
                return n;
            }

            int lastTerm = fib_rec(n - 1);
            int secondLastTerm = fib_rec(n - 2);

            return lastTerm + secondLastTerm;
        }

        // memoasation
        public static int fibo_memo(int n, int[] dp) {

            //base case 
            if (n == 0 || n == 1) {
                return dp[n] = n;
            }

            // check if answer is already present
            if (dp[n] != 0) {
                return dp[n];
            }

            int lastTerm = fibo_memo(n - 1, dp);
            int secondLastTerm = fibo_memo(n - 2, dp);

            // jane se pahile store the answer
            return dp[n] = lastTerm + secondLastTerm;
        }

        // tabulation
        public static int fib_tabulation(int N) {
            int[] memo = new int[N + 1];

            for (int n = 0; n <= N; n++) {
                if (n == 0 || n == 1) {
                    memo[n] = n;
                    continue;
                }

                int lastTerm = memo[n - 1];
                int secondLastTerm = memo[n - 2];

                memo[n] = lastTerm + secondLastTerm;
            }

            return memo[N];

        }

        public static int fibonacci(int n) {
            int[] memo = new int[n + 1];

            // return fib_rec(n);

            // return fibo_memo(n, memo);

            // return fib_tab(n);

            return fib_tabulation(n);
        }

    }

    // Friends Pairing problem :
    // https://www.geeksforgeeks.org/problems/friends-pairing-problem5425/1
    class FriensPairUp {

        public long countFriendsPairings_rec(int n) {
            if (n <= 2) {
                return n;
            }

            long single = countFriendsPairings_rec(n - 1);

            long pairUp = (n - 1) * countFriendsPairings_rec(n - 2);

            return single + pairUp;
        }

        public long countFriendsPairings_memo(int n, long[] dp) {
            if (n <= 2) {
                return dp[n] = n;
            }

            if (dp[n] != 0) {
                return dp[n];
            }

            long single = countFriendsPairings_memo(n - 1, dp);

            long pairUp = (n - 1) * countFriendsPairings_memo(n - 2, dp);

            return dp[n] = single + pairUp;
        }

        public long countFriendsPairings_tab(int n, long[] dp) {

            for (int i = 1; i <= n; i++) {
                if (i <= 2) {
                    dp[i] = i;
                    continue;
                }

                long single = dp[i - 1];// countFriendsPairings_memo(n-1,dp);

                long pairUp = (i - 1) * dp[i - 2]; // countFriendsPairings_memo(n-2,dp);

                dp[i] = single + pairUp;
            }

            return dp[n];
        }

        public long countFriendsPairings(int n) {

            long[] dp = new long[n + 1];

            return countFriendsPairings_tab(n, dp);

            // return countFriendsPairings_memo(n,dp);

            // return countFriendsPairings_rec(n);

        }
    }

    // Leetcode 70 : https://leetcode.com/problems/climbing-stairs/
    class Solution70 {

        public static int climbStairs_rec(int n) {

            if (n <= 2) {
                return n;
            }

            int oneStep = climbStairs_rec(n - 1);
            int twoStep = climbStairs_rec(n - 2);

            return oneStep + twoStep;
        }

        public static int climbStairs_memo(int n, int[] dp) {

            if (n <= 2) {
                return dp[n] = n;
            }

            if (dp[n] != 0) {
                return dp[n];
            }

            int oneStep = climbStairs_memo(n - 1, dp);
            int twoStep = climbStairs_memo(n - 2, dp);

            return dp[n] = oneStep + twoStep;
        }

        public static int climbStairs_tab(int N, int[] dp) {
            for (int n = 0; n <= N; n++) {
                if (n <= 2) {
                    dp[n] = n;
                    continue;
                }

                int oneStep = dp[n - 1];// climbStairs_memo(n - 1, dp);
                int twoStep = dp[n - 2];// climbStairs_memo(n - 2, dp);

                dp[n] = oneStep + twoStep;
            }

            return dp[N];
        }

        public static int climbStairs(int n) {
            int[] dp = new int[n + 1];

            return climbStairs_tab(n, dp);

            // return climbStairs_memo(n, dp);

            // return climbStairs_rec(n);

        }

    }

    public static int totalMazePath_rec(int row,int col,int n,int m){
        return -1;
    }
    public static void main(String[] args) {
        
    }
}
