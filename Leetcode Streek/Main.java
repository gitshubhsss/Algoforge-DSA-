class Main {

    class Solution3660 {

        public int[] maxValue(int[] nums) {

            int n = nums.length;

            /// Making the max prefix and the min prefix
            int[] maxPrefix = new int[n];

            int[] minSuffix = new int[n];

            int max = nums[0];
            maxPrefix[0] = max;
            // moving -----------------> left to right
            for (int i = 1; i < n; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
                maxPrefix[i] = max;
            }

            int min = nums[n - 1];
            minSuffix[n - 1] = nums[n - 1];
            // moving <----------------- right to left
            for (int i = n - 2; i >= 0; i--) {
                if (min > nums[i]) {
                    min = nums[i];
                }
                minSuffix[i] = min;
            }

            int[] ans = new int[n];
            ans[n - 1] = maxPrefix[n - 1];

            for (int i = n - 2; i >= 0; i--) {
                if (maxPrefix[i] <= minSuffix[i + 1]) {
                    ans[i] = maxPrefix[i];
                } else {
                    ans[i] = ans[i + 1];
                }
            }

            return ans;

        }

    }

    public static void main(String[] args) {

    }
}