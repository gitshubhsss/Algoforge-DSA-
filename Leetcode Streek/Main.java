import java.util.HashSet;

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

    class Solution2657 {
        class Solution {

            public int[] findThePrefixCommonArray(int[] A, int[] B) {
                HashSet<Integer> set = new HashSet<>();

                int[] ans = new int[A.length];

                for (int i = 0; i < A.length; i++) {
                    int count = 0;
                    set.add(B[i]);
                    // 3
                    for (int j = 0; j <= i; j++) {
                        if (set.contains(A[j])) {
                            count++;
                        }
                    }

                    ans[i] = count;

                }

                return ans;

            }
        }
    }

    class Solution33 {
        public static int search(int[] nums, int target) {

            int start = 0;
            int end = nums.length - 1;

            while (start <= end) {

                int mid = (start + end) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[start] <= nums[mid]) {// check if the left array is sorted or not
                    if ((nums[start] <= target) && (target <= nums[mid])) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if ((nums[mid] <= target) && (target <= nums[end])) {// check if right array is sorted or not
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }

            }

            return -1;
        }

    }

    public static void main(String[] args) {

    }
}