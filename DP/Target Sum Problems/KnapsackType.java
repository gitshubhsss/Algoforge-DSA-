import java.util.Arrays;

public class KnapsackType {

    public static Boolean isSubsetSum_rec_rev(int idx, int arr[], int tar) {
        if (idx == 0 || idx == 1) {
            return tar == 0;
        }

        Boolean isPossible = false;

        if (tar - arr[idx] >= 0) {
            isPossible = isSubsetSum_rec_rev(idx - 1, arr, tar - arr[idx]);
        }

        isPossible = isPossible || isSubsetSum_rec_rev(idx - 1, arr, tar);

        return isPossible;

    }

    public static Boolean isSubsetSum_rec(int idx, int arr[], int tar) {
        if (idx == arr.length) {
            return tar == 0;
        }

        Boolean isPossible = false;

        if (tar - arr[idx] >= 0) {
            isPossible = isSubsetSum_rec(idx + 1, arr, tar - arr[idx]);
        }

        isPossible = isPossible || isSubsetSum_rec(idx + 1, arr, tar);

        return isPossible;
    }

    public static Boolean isSubsetSum_memo(int idx, int[] arr, int tar, Boolean[][] dp) {
        if (idx == arr.length) {
            return dp[idx][tar] = tar == 0;
        }

        if (dp[idx][tar] != null) {
            return dp[idx][tar];
        }
        Boolean isPossible = false;

        if (tar - arr[idx] >= 0) {
            isPossible = isSubsetSum_memo(idx + 1, arr, tar - arr[idx], dp);
        }

        isPossible = isPossible || isSubsetSum_memo(idx + 1, arr, tar, dp);

        return dp[idx][tar] = isPossible;
    }

    public static Boolean isSubsetSum_memo2(int n, int[] arr, int tar, Boolean[][] dp) {
        if (n == 0) {
            return dp[n][tar] = tar == 0;
        }

        if (dp[n][tar] != null) {
            return dp[n][tar];
        }
        Boolean isPossible = false;

        if (tar - arr[n - 1] >= 0) {
            isPossible = isSubsetSum_memo(n - 1, arr, tar - arr[n], dp);
        }

        isPossible = isPossible || isSubsetSum_memo(n - 1, arr, tar, dp);

        return dp[n][tar] = isPossible;
    }

    public static Boolean isSubSet_tab(int[] arr, int tar, Boolean[][] dp) {

        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == arr.length) {
                dp[i][tar] = tar == 0;
                continue;
            }

            Boolean isPossible = false;

            if (tar - arr[i] >= 0) {
                isPossible = dp[i + 1][tar - arr[i]]; // isSubsetSum_memo(idx + 1, arr, tar - arr[idx], dp);
            }

            isPossible = isPossible || dp[i + 1][tar]; // isSubsetSum_memo(idx + 1, arr, tar, dp);

            dp[i][tar] = isPossible;
        }

        return dp[0][0];

    }

    // https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
    static Boolean isSubsetSum(int arr[], int sum) {

        int n = arr.length;

        Boolean[][] dp = new Boolean[n + 1][sum + 1];

        return isSubsetSum_memo(0, arr, sum, dp);

        // return isSubsetSum_rec(0, arr, sum);

    }

    public static int perfectSum_rec(int n, int[] nums, int target) {
        if (n == 0) {
            return target == 0 ? 1 : 0;
        }

        // yes call
        int subset = 0;
        if (target - nums[n - 1] >= 0) {
            subset += perfectSum_rec(n - 1, nums, target - nums[n - 1]);

        }

        // no call
        subset += perfectSum_rec(n - 1, nums, target);

        return subset;
    }

    public static int perfectSum_memo(int n, int[] nums, int target, int[][] dp) {
        if (n == 0) {
            return dp[n][target] = target == 0 ? 1 : 0;
        }

        if (dp[n][target] != -1) {
            return dp[n][target];
        }
        // yes call
        int subset = 0;
        if (target - nums[n - 1] >= 0) {
            subset += perfectSum_memo(n - 1, nums, target - nums[n - 1], dp);

        }

        // no call
        subset += perfectSum_memo(n - 1, nums, target, dp);

        return dp[n][target] = subset;
    }

    public static int perfectSum_tab(int N, int[] nums, int Target, int[][] dp) {

        for (int n = 0; n <= N; n++) {
            for (int tar = 0; tar <= Target; tar++) {
                if (n == 0) {
                    dp[n][tar] = tar == 0 ? 1 : 0;
                    continue;
                }

                // yes call
                int subset = 0;
                if (tar - nums[n - 1] >= 0) {
                    subset += dp[n - 1][tar - nums[n - 1]]; // perfectSum_memo(n - 1, nums, tar - nums[n - 1], dp);

                }

                // no call
                subset += dp[n - 1][tar]; // perfectSum_memo(n - 1, nums, tar, dp);

                dp[n][tar] = subset;
            }
        }

        return dp[N][Target];
    }

    // Function to calculate the number of subsets with a given sum
    public static int perfectSum(int[] nums, int target) {
        // code here

        int n = nums.length;

        int[][] dp = new int[n + 1][target + 1];

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return perfectSum_tab(n, nums, target, dp);

        // return perfectSum_memo(n, nums, target, dp);

        // return perfectSum_rec(n, nums, target);

    }

    public static int knapsack_rec(int n, int cap, int val[], int[] wt) {
        if (n == 0) {
            return 0;
        }

        int maxProfit = 0;
        // yes call
        if (cap - wt[n - 1] >= 0) {// the capacity should be greater the weight we are about to pick
            maxProfit += knapsack_rec(n - 1, cap - wt[n - 1], val, wt) + val[n - 1];
        }

        maxProfit = Math.max(maxProfit, knapsack_rec(n - 1, cap, val, wt));

        // no call
        return maxProfit;
    }

    public static int knapsack_memo(int n, int cap, int val[], int[] wt, int[][] dp) {
        if (n == 0) {
            return dp[n][cap] = 0;
        }

        if (dp[n][cap] != -1) {
            return dp[n][cap];
        }

        int maxProfit = 0;
        // yes call
        if (cap - wt[n - 1] >= 0) {// the capacity should be greater the weight we are about to pick
            maxProfit += knapsack_memo(n - 1, cap - wt[n - 1], val, wt, dp) + val[n - 1];
        }

        maxProfit = Math.max(maxProfit, knapsack_memo(n - 1, cap, val, wt, dp));

        // no call
        return dp[n][cap] = maxProfit;
    }

    public static int knapsack_tab(int N, int CAP, int val[], int[] wt, int[][] dp) {

        for (int n = 0; n <= N; n++) {
            for (int cap = 0; cap <= CAP; cap++) {
                if (n == 0) {
                    dp[n][cap] = 0;
                    continue;
                }

                int maxProfit = 0;
                // yes call
                if (cap - wt[n - 1] >= 0) {// the capacity should be greater the weight we are about to pick
                    maxProfit += dp[n - 1][cap - wt[n - 1]] + val[n - 1]; // knapsack_memo(n - 1, cap - wt[n - 1], val,
                                                                          // wt, dp) + val[n - 1];
                }

                maxProfit = Math.max(maxProfit, dp[n - 1][cap]);// knapsack_memo(n - 1, cap, val, wt, dp));

                // no call
                dp[n][cap] = maxProfit;
            }
        }

        return dp[N][CAP];
    }

    public static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = wt.length;

        int cap = W;

        int[][] dp = new int[n + 1][cap + 1];

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return knapsack_tab(n, cap, val, wt, dp);

        // return knapsack_memo(n, cap, val, wt, dp);
        // return knapsack_rec(n, W, val, wt);
    }

    // https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
    public int knapSack(int val[], int wt[], int capacity) {

        int n = wt.length;
        int[] dp = new int[capacity + 1];

        for (int idx = 0; idx < n; idx++) {
            for (int cap = wt[idx]; cap <= capacity; cap++) {
                dp[cap] = Math.max(dp[cap], dp[cap - wt[idx]] + val[idx]);
            }
        }

        return dp[capacity];
    }

    public int knapSack_rev(int val[], int wt[], int capacity) {

        int n = wt.length;
        int[] dp = new int[capacity + 1];

        for (int cap = 0; cap <= capacity; cap++) {

            for (int idx = 0; idx < n; idx++) {
                if (cap - wt[idx] >= 0) {
                    dp[cap] = Math.max(dp[cap], dp[cap - wt[idx]] + val[idx]);
                }
            }
        }

        return dp[capacity];
    }

    // code pending
    public int findTargetSumWays(int idx, int nums[], int target) {

        return idx;
    }

    public int findTargetSumWays(int[] nums, int target) {

        return -1;

    }

    public static void main(String[] args) {
        // int[] nums = { 5, 2, 3, 10, 6, 8 };
        // int target = 10;

        // System.out.println(perfectSum(nums, target));
        int W = 5;
        int val[] = { 10, 40, 30, 50 };
        int wt[] = { 5, 4, 2, 3 };

        System.out.println(knapsack(W, val, wt));

    }

}
