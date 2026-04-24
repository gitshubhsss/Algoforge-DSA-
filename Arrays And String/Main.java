import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Main {

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void segregatePosNeg(int[] arr) {
        int n = arr.length;

        int i = -1;
        int j = n - 1;

        while (i < j) {
            if (arr[i + 1] < 0) {
                i++;
            } else {
                swap(i + 1, j, arr);
                j--;
            }
        }
    }

    /// https://www.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1

    class Solution {

        public static void swap(int i, int j, int[] arr) {

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        void segregate0and1(int[] arr) {
            // code here
            int n = arr.length;
            int i = -1;
            int j = n - 1;

            while (i < j) {
                if (arr[i + 1] == 0) {
                    i++;
                } else {
                    swap(i + 1, j, arr);
                    j--;
                }
            }
        }
    }

    // 75. Sort Colors
    class Solution75 {

        public static void swap(int i, int j, int[] arr) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public void sortColors(int[] nums) {

            int n = nums.length;

            int p1 = -1;
            int p2 = 0;
            int p3 = n - 1;

            while (p2 <= p3) {
                if (nums[p2] == 1) {
                    p2++;// increase area of one
                } else if (nums[p2] == 2) {
                    swap(p2, p3, nums);// shift to end of the unexplored area
                    p3--;// last of unexplored area is now under 2 ka area
                } else {
                    swap(p1 + 1, p2, nums);
                    p1++;
                    p2++;
                }
            }
        }
    }

    class Solution1456 {

        public static boolean isVowel(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }

        public int maxVowels(String s, int k) {

            int n = s.length();

            int si = 0;
            int ei = 0;

            int curr = 0;
            int max = 0;

            while (ei < n) {
                if (isVowel(s.charAt(ei))) {
                    curr++;
                }
                ei++;

                while (ei - si > k) {
                    if (isVowel(s.charAt(si))) {
                        curr--;
                    }
                    si++;
                }

                if (ei - si == k) {
                    max = Math.max(curr, max);
                }
            }

            return max;
        }

    }

    /// Sliding window
    class Solution239 {
        public int[] maxSlidingWindow(int[] nums, int k) {

            LinkedList<Integer> deque = new LinkedList<>();
            int n = nums.length;
            int[] ans = new int[n - k + 1];
            int answerIndex = 0;// to travel

            for (int i = 0; i < nums.length; i++) {

                // remove the last element
                while (deque.size() > 0 && nums[deque.getLast()] < nums[i]) {
                    deque.removeLast();
                }

                if (!deque.isEmpty() && deque.getFirst() <= i - k) {
                    deque.removeFirst();
                }

                deque.add(i);// 1,2

                if (i >= k - 1) {
                    ans[answerIndex] = nums[deque.getFirst()];
                    answerIndex++;
                }

            }
            return ans;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int[] ans = new int[n - k + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
            return b[0] - a[0];
        });

        for (int i = 0; i < n; i++) {
            // adding the element in the priority queue
            pq.add(new int[] { nums[i], i });

            while (pq.size() > 0 && pq.peek()[1] <= i - k) {// removing the maximum element only if its not present i
                                                            // the window
                pq.remove();
            }

            if (i >= k - 1) {
                ans[i - k + 1] = pq.peek()[0];
            }

        }
        return ans;
    }

    class Solution658 {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {

            int n = arr.length;
            List<Integer> res = new ArrayList<>();
            for (int e : arr)
                res.add(e);

            if (x < arr[0]) {
                return res.subList(0, k);
            } else if (x > arr[n - 1]) {
                return res.subList(n - k, n);
            }

            return new ArrayList<>();

        }
    }

    class Solution1 {

        public boolean isPossible(int[] stalls, int k, int dis) {
            int lastPlacedCow = stalls[0];
            k--;
            for (int i = 1; i < stalls.length; i++) {
                if (stalls[i] - lastPlacedCow >= dis) {
                    k--;
                    lastPlacedCow = stalls[i];
                }
            }
            return k <= 0;
        }

        public int aggressiveCows(int[] stalls, int k) {
            // code here

            Arrays.sort(stalls);

            int left = 1;
            int right = (int) (1e9);// stalls[n-1]-stalls[0];

            while (left <= right) {
                int mid = (left + right) / 2;

                if (isPossible(stalls, k, mid)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return left;

        }
    }

    class Solution875 {

        public boolean isPossible(int[] stalls, int k, int dis) {
            int lastPlacedCow = stalls[0];
            k--;
            for (int i = 1; i < stalls.length; i++) {
                if (stalls[i] - lastPlacedCow >= dis) {
                    k--;
                    lastPlacedCow = stalls[i];
                }
            }
            return k <= 0;
        }

        public int minEatingSpeed(int[] piles, int h) {

            int left = 1;
            int right = (int) (1e9);// stalls[n-1]-stalls[0];

            while (left <= right) {
                int mid = (left + right) / 2;

                if (isPossible(piles, h, mid)) {
                    left = mid - 1;
                } else {
                    right = mid + 1;
                }
            }

            return left;

        }
    }

    class Solution2226 {

        public boolean isPossible(int mid, int[] candies, long k) {

            for (int i = 0; i < candies.length; i++) {
                k = k - (candies[i] / mid);
                if (k <= 0) {
                    return true;
                }
            }

            return false;
        }

        public int maximumCandies(int[] candies, long k) {
            int left = 1;
            int right = (int) (1e9);
            while (left <= right) {
                int mid = (left + right) / 2;
                if (isPossible(mid, candies, k)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left - 1;
        }
    }

    class Solution1011 {

        public boolean isPossible(int[] weights, int days, int capacity) {

            int currWeight = 0;
            for (int i = 0; i < weights.length; i++) {
                currWeight += weights[i];

                if (currWeight > capacity) {
                    days--;
                    currWeight = weights[i];
                }

                if (days <= 0)
                    return false;
            }

            return true;
        }

        public int shipWithinDays(int[] weights, int days) {
            int maxWeight = 0;
            int sumOfWeight = 0;

            for (int e : weights) {
                maxWeight = Math.max(maxWeight, e);
                sumOfWeight += e;
            }

            int left = maxWeight;
            int right = sumOfWeight;

            int minCap = 0;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (isPossible(weights, days, mid)) {
                    minCap = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return minCap;
        }

    }

    class Solution410 {

        public boolean isPossible(int []nums,int k,int maxSubArraySum){
            int csum=0;
            for(int i=0;  i<nums.length;i++ ){
                
            }
        }

        public int splitArray(int[] nums, int k) {
            int max = 0;
            int sum = 0;
            for (int e : nums) {
                max = Math.max(max, e);
                sum += e;
            }

            int left = max;
            int right = sum;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (isPossible(nums, k, mid)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

        }
    }

    public static void main(String[] args) {
        int arr[] = { 8, -11, 11, -9, -4, 14, 19, -7, -12 };
        segregatePosNeg(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}