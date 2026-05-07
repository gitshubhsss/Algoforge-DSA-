
public class Main {

    public static void addTwoArrays(int[] arr1, int[] arr2) {

        int n1 = arr1.length;
        int n2 = arr2.length;

        // create the result array

        int[] res = new int[Math.max(n1, n2) + 1];// resultant array will be max length of n1 and n2 +1
        int n3 = res.length;
        // initialize the pointers will start it from the last

        int i = n1 - 1;
        int j = n2 - 1;
        int k = n3 - 1;

        int carry = 0;

        while (k >= 0) {
            int cSum = 0;
            // add the first array element
            if (i >= 0) {
                cSum += arr1[i];
            }

            if (j >= 0) {
                cSum += arr2[j];
            }

            cSum += carry;// 12

            if (cSum > 9) {
                int temp = cSum % 10;
                carry = cSum / 10;
                cSum = temp;
            } else {
                carry = 0;
            }
            res[k] = cSum;
            k--;
            j--;
            i--;

        }

        // prin the answer
        i = 0;
        while (i < res.length) {
            System.out.print(res[i] + " ");
            i++;
        }
    }

    /// the first array is bigger than last array
    public static void subTwoArrays(int[] arr1, int[] arr2) {

        int n1 = arr1.length;
        int n2 = arr2.length;

        // create the result array
        // 9256
        // 4589
        int[] res = new int[n1];
        int n3 = res.length;
        // initialize the pointers will start it from the last

        int i = n1 - 1;
        int j = n2 - 1;
        int k = n3 - 1;

        int carry = 0;

        while (k >= 0) {
            int cSum = 0;
            // add the first array element

            if (i >= 0) {
                cSum += arr1[i];
            }
            // minimizing the carry
            cSum = cSum - carry;

            if (j >= 0) {
                if (cSum >= arr2[j]) {
                    cSum = cSum - arr2[j];
                    carry = 0;
                } else {
                    cSum = (cSum + 10) - arr2[j];
                    carry = 1;
                }
            }

            res[k] = cSum;
            k--;
            j--;
            i--;

        }

        // prin the answer
        i = 0;
        while (i < res.length) {
            System.out.print(res[i] + " ");
            i++;
        }
    }

    public static void printBuildingHeight(int[] heights) {
        int maxHeight = 0;

        for (int i = 0; i < heights.length; i++) {
            maxHeight = Math.max(maxHeight, heights[i]);
        }

        int currentFloor = maxHeight;

        while (currentFloor > 0) {

            // int[] heights = { 3, 5, 1, 4, 2, 8, 9 };
            for (int i = 0; i < heights.length; i++) {

                int currentHeight = heights[i];

                if (currentFloor <= currentHeight) {
                    System.out.print("* ");
                } else {
                    System.out.print("_ ");
                }
            }

            System.out.println();

            currentFloor--;
        }
    }

    // helper function to print the array
    public static void printArray(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // this is the first way to reverse the array
    public static void reverseArray1(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }

        printArray(arr);

    }

    public static void reverseArray2(int[] arr) {
        int n = arr.length;

        int start = 0;
        int end = n - 1;

        while (start <= end) {

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        printArray(arr);
    }

    /// Leetcode 26 (Remove
    /// Duplicates)https://leetcode.com/problems/remove-duplicates-from-sorted-array/

    public static int removeDuplicates(int[] nums) {

        int n = nums.length;
        int size = n;

        int prev = nums[0];
        int uIdx = 0;// unique index element

        for (int i = 1; i < n; i++) {
            int curr = nums[i];

            if (prev != curr) {
                // unique elemnt found
                nums[uIdx] = prev;
                uIdx++;
            } else {
                size--;
            }
            prev = curr;
        }

        // adding the previous element
        nums[uIdx] = prev;

        printArray(nums);
        System.out.println();

        return size;
    }

    /// Leetcode 189 (Rotate array)
    /// https://leetcode.com/problems/rotate-array/description/

    public static void rotate(int[] nums, int k) {

        int n = nums.length;

        // find k which is really important
        k = k % n;
        if (k < 0) {
            k = k + n;
        }

        // A'
        swap(nums, 0, n - k - 1);

        // B'
        swap(nums, n - k, n - 1);

        // AB'
        swap(nums, 0, n - 1);

        printArray(nums);

    }

    public static void swap(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        // int[] heights = { 3, 5, 1, 4, 2, 8, 9 };
        // printBuildingHeight(heights);

        // int[] arr1 = { 6, 5, 3 };
        // int[] arr2 = { 7, 8, 5, 3 };

        // addTwoArrays(arr1, arr2);

        // int[] arr1 = { 9, 2, 5, 6 };
        // int[] arr2 = { 4, 5, 8, 9 };

        // subTwoArrays(arr1, arr2);

        // int[] arr = { 1, 2, 3, 4, 5 };

        // // reverseArray1(arr);
        // reverseArray2(arr);

        // int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

        // System.out.println(removeDuplicates(nums));

        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };

        rotate(nums, 3);
    }
}
