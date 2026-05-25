import java.util.ArrayList;
import java.util.HashMap;
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

    /// Contest 183
    class Solution {
        public int minimumSwaps(int[] nums) {

            int swapCount = 0;
            int n = nums.length;
            int j = n - 1;

            for (int i = 0; i < n; i++) {
                // find the last non zero index;
                while (nums[j] == 0 && i < j) {
                    j--;
                }

                if (nums[i] == 0 && nums[j] != 0 && i < j) {// swap zero with non zero index;
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    swapCount++;
                    j--;
                }

            }
            return swapCount;
        }
    }

    class Solution58 {
        public int lengthOfLastWord(String s) {

            int n = s.length();
            int length = 0;
            boolean hasChar = false;

            for (int i = n - 1; i >= 0; i--) {

                if (s.charAt(i) != ' ') {
                    length++;
                    hasChar = true;
                } else if (hasChar) {
                    return length;
                }

            }
            return length;

        }
    }

    class Solution3941 {
        public int passwordStrength(String password) {

            HashSet<Character> set = new HashSet<>();

            int n = password.length();

            for (int i = 0; i < n; i++) {
                set.add(password.charAt(i));
            }

            int strength = 0;

            for (char c : set) {
                if (c >= 'a' && c <= 'z') {
                    strength += 1;
                } else if (c >= 'A' && c <= 'Z') {
                    strength += 2;
                } else if (c >= '0' && c <= '9') {
                    strength += 3;
                } else {
                    strength += 5;
                }

            }

            return strength;
        }
    }

    class Solution3940 {
        public int[] limitOccurrences(int[] nums, int k) {

            ArrayList<Integer> list = new ArrayList<>();

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int ele = nums[i];

                if (map.containsKey(ele) == false) {
                    map.put(ele, 1);
                    list.add(ele);
                } else {
                    // get older frequency which should be less than k
                    int olderFreq = map.get(ele);
                    if (olderFreq < k) {
                        map.put(ele, olderFreq + 1);
                        list.add(ele);
                    }
                }
            }

            int[] ans = new int[list.size()];

            for (int i = 0; i < ans.length; i++) {
                ans[i] = list.get(i);
            }

            return ans;
        }
    }

    public static void main(String[] args) {

    }
}