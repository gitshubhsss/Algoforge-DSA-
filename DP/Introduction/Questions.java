class Questions {

    // Friends Pairing
    public long friendsPairing_rec(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        long single = friendsPairing_rec(n - 1);
        long pairUp = (n - 1) * friendsPairing_rec(n - 2);

        return single + pairUp;
    }

    public long friendsPairing_memo(int n, long[] dp) {
        if (n == 0 || n == 1) {
            return dp[n] = 1;
        }

        if (dp[n] != 0)
            return dp[n];

        long single = friendsPairing_memo(n - 1, dp);
        long pairUp = (n - 1) * friendsPairing_memo(n - 2, dp);

        return dp[n] = single + pairUp;
    }

    public long friendsPairing_tab(int N, long[] dp) {

        for (int n = 0; n <= N; n++) {
            if (n == 0 || n == 1) {
                dp[n] = 1;
                continue;
            }

            long single = dp[n - 1]; // friendsPairing_memo(n-1, dp);
            long pairUp = (n - 1) * dp[n - 2]; // (n-1)*friendsPairing_memo(n-2, dp);

            dp[n] = single + pairUp;
        }

        return dp[N];
    }

    public long countFriendsPairings(int n) {
        // return friendsPairing_rec(n);

        long[] dp = new long[n + 1];
        // return friendsPairing_memo(n, dp);
        return friendsPairing_tab(n, dp);
    }

    // Climb stairs probjem
    public static int climbStairs_rec(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }

        int oneStep = climbStairs_rec(n - 1);
        int twoStpe = climbStairs_rec(n - 2);

        return oneStep + twoStpe;
    }

    public static int climbStairs_memo(int n, int[] dp) {
        if (n == 1 || n == 0) {
            return dp[n] = 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int oneStep = climbStairs_rec(n - 1);
        int twoStpe = climbStairs_rec(n - 2);

        return dp[n] = oneStep + twoStpe;
    }

    public static int climbStairs_tabulation(int n, int[] dp) {

        for (int i = 0; i <= n; i++) {
            if (n == 1 || n == 0) {
                dp[i] = 1;
                continue;
            }

            int oneStep = dp[i - 1];
            int twoStpe = dp[i - 2];

            dp[i] = oneStep + twoStpe;
        }
        return dp[n];
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int oneStep = climbStairs(n - 1);
        int twoStpe = climbStairs(n - 2);

        return oneStep + twoStpe;
    }

    public static void main(String[] args) {

    }

}