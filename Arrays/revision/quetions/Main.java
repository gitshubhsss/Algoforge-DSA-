import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    // Function to find number of elements which are greater than x

    public static int countGreaterThanEle(int arr[], int ele) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > ele) {
                count++;
            }
        }

        return count;

    }

    // 5, 3, 4, 11, 9, 2
    public static int countGreaterThanEleWithRec(int arr[], int ele, int idx) {

        if (idx == arr.length) {
            return 0;
        }

        int countSofar = countGreaterThanEleWithRec(arr, ele, idx + 1);

        if (arr[idx] > ele) {
            countSofar++;
        }

        return countSofar;

    }

    // 5, 3, 4, 11, 9, 2 ele=4 ans=2
    public static int searchInUnsortedArray(int arr[], int ele) {

        int idx = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ele) {
                idx = i;
            }
        }

        return idx;

    }

    // 5,4,3, 4, 11, 9, 2 ele=4 ans=2
    public static int searchInUnsortedArrayWithRec(int arr[], int ele, int idx) {

        if (idx == arr.length) {
            return -1;
        }

        int smallAns = searchInUnsortedArrayWithRec(arr, ele, idx + 1);

        if (arr[idx] == ele) {
            return idx;
        }

        return smallAns;
    }

    // 1, 4, 3, -5, -4, 8, 6
    public static ArrayList<Integer> getMinMax(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();

        int minValue = Integer.MAX_VALUE;
        int maxValue = arr[0];

        for (int i = 0; i < arr.length; i++) {
            int ele = arr[i];

            if (ele > maxValue) {
                maxValue = ele;
            }

            if (minValue > ele) {
                minValue = ele;
            }
        }

        ans.add(minValue);
        ans.add(maxValue);
        return ans;
    }

    // 1, 4, 3, -5, -4, 8, 6
    public static ArrayList<Integer> getMinMaxWithRec(int arr[], int idx) {

        if (idx == arr.length) {
            ArrayList<Integer> baseAns = new ArrayList<>();
            baseAns.add(0, Integer.MAX_VALUE);// 0 is for small and 1 is max
            baseAns.add(1, -1);
            return baseAns;
        }

        ArrayList<Integer> smallAns = getMinMaxWithRec(arr, idx + 1);

        int min = smallAns.get(0);
        int max = smallAns.get(1);

        if (arr[idx] > max) {
            smallAns.set(1, arr[idx]);
        }

        if (arr[idx] < min) {
            smallAns.set(0, arr[idx]);
        }

        return smallAns;
    }

    public static String calc_Sum(int arr1[], int arr2[]) {

        int n1 = arr1.length;
        int n2 = arr2.length;
        // Decide the size of the ans
        int ans[] = new int[Math.max(n1, n2) + 1];
        int n3 = ans.length;

        // Initialize the pointers

        int i = n1 - 1;
        int j = n2 - 1;
        int k = n3 - 1;

        int borrow = 0;
        while (k >= 0) {

            int sum = 0;

            if (i >= 0) {
                sum = sum + arr1[i];
            }

            if (j >= 0) {
                sum = sum + arr2[j];
            }

            sum = sum + borrow;

            if (sum > 9) {
                sum = sum % 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            ans[k] = sum;

            i--;
            j--;
            k--;

        }

        StringBuilder str = new StringBuilder();

        for (int idx = 0; idx < ans.length; idx++) {
            if (idx == 0 && ans[idx] == 0) {

            } else {
                str.append(ans[idx]);
            }
        }

        return str.toString();

    }

    public static String calcSumWithRec(int arr1[], int arr2[], int ans[], int i, int j, int k, int borrow) {
        if (k < 0) {
            return "";
        }

        int sum = 0;

        if (i >= 0) {
            sum = sum + arr1[i];
        }

        if (j >= 0) {
            sum = sum + arr2[j];
        }

        sum = sum + borrow;
        if (sum > 9) {
            sum = sum % 10;
            borrow = 1;
        } else {
            borrow = 0;
        }

        String smallAns = calcSumWithRec(arr1, arr2, ans, i - 1, j - 1, k - 1, borrow);

        return smallAns + sum;

    }

    // first array will be always greater than or equal to the second array
    public static String calc_sub(int arr1[], int arr2[]) {

        int n1 = arr1.length;
        int n2 = arr2.length;
        int ans[] = new int[Math.max(n1, n2)];
        int n3 = ans.length;

        // initialize the pointers

        int i = n1 - 1;
        int j = n2 - 1;
        int k = n3 - 1;

        int borrow = 0;
        while (k >= 0) {

            int sub = 0;

            if (i >= 0) {
                sub = sub + arr1[i];
            }

            if (j >= 0) {
                if (arr2[j] > sub) {
                    sub = (sub + 10) - arr2[j];
                    borrow = 1;
                } else {
                    sub = sub - arr2[j];
                    borrow = 0;
                }
            }

            ans[k] = sub;

            i--;
            j--;
            k--;

        }

        StringBuilder str = new StringBuilder();
        for (int idx = 0; idx < ans.length; idx++) {
            str.append(ans[idx]);
        }
        return str.toString();
    }

    // with recursion
    public static String calcSubWithRec(int arr1[], int arr2[], int ans[], int i, int j, int k, int borrow) {
        if (k < 0) {
            return "";
        }

        int sub = 0;

        if (i >= 0) {
            sub = sub + arr1[i];
        }

        if (j >= 0) {
            if (arr2[j] > sub) {
                sub = (sub + 10) - arr2[j];
                borrow = 1;
            } else {
                sub = sub - arr2[j];
                borrow = 0;
            }
        }

        ans[k] = sub;

        String smallAns = calcSubWithRec(arr1, arr2, ans, i - 1, j - 1, k - 1, borrow);

        String myAns = smallAns + sub;

        return myAns;

    }

    public static void reverseArray(int arr[]) {

        // ==================================Method 1==========================
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // =================================Method 2=================================

        // int n = arr.length - 1;

        // for (int i = 0; i < arr.length / 2; i++) {
        // int temp = arr[i];
        // arr[i] = arr[n - i];
        // arr[n - i] = temp;
        // }

        // for (int i = 0; i < arr.length; i++) {
        // System.out.println(arr[i]);
        // }

    }

    public static int findFloor(int[] arr, int x) {
        int n = arr.length;
        int floor = -1;

        int si = 0;
        int ei = n - 1;

        while (si <= ei) {

            int mid = (si + ei) / 2;

            if (arr[mid] <= x) {
                floor = arr[mid];
                // still we are going to find the larst

                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        return floor;

    }

    public static int findFloorRec(int arr[], int x, int start, int end, int floor) {
        if (start >= end) {
            return floor;
        }

        int mid = (start + end) / 2;

        if (arr[mid] <= x) {
            start = mid + 1;
            floor = arr[mid];
        } else {
            end = mid - 1;
        }

        int smallAns = findFloorRec(arr, x, start, end, floor);

        return smallAns;

    }

    // 12, -9, 76, 43, 12
    public static int findSecondLarge(int arr[]) {

        if (arr.length == 0) {
            return -1;
        }

        int lg = arr[0];

        int sl = -1;

        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];

            if (curr >= lg) {
                sl = lg;
                lg = curr;
            } else if (curr >= sl && curr <= lg) {
                sl = curr;
            }

        }

        return sl;
    }

    public static int findConcecativeZeroAndOne(int arr[]) {

        int count = 1;

        int prev = arr[0];

        int maxCount = Integer.MIN_VALUE;
        // 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];

            if (curr == prev) {
                count++;
            } else {
                count = 1;
            }
            if (maxCount < count) {
                maxCount = count;
            }

            prev = curr;
        }

        return maxCount;
    }

    public static void shellRotate(int n, int m, int s, int k, List<List<Integer>> matrix) {
        // Write your code here
        while (k >= 1) {

            int startRow = s - 1;// 1
            int startCol = s - 1;// 1

            int endRow = n - s;

            int endCol = m - s;

            // print the left wall
            for (int row = startRow; row <= endRow; row++) {
                System.out.print(matrix.get(row).get(startCol) + " ");
            }
            startCol++;

            System.out.println();
            // print the bottom wal
            for (int col = startCol; col <= endCol; col++) {
                System.out.print(matrix.get(endRow).get(col) + " ");
            }
            endRow--;

            //
            System.out.println();
            for (int row = endRow; row >= startRow; row--) {
                System.out.print(matrix.get(row).get(endCol) + " ");
            }

            endCol--;

            System.out.println();

            for (int col = startCol; col <= endCol; col++) {
                System.out.print(matrix.get(startRow).get(col) + " ");
            }
            startRow++;

            System.out.println();

            k--;

        }
    }

    // 11 12 13 14 15 16 17
    // 21 22 23 24 25 26 27
    // 31 32 33 34 35 36 37
    // 41 42 43 44 45 46 47
    // 51 52 53 54 55 56 57

    // 11 12 13 14 15 16 17
    // 21 43 42 32 22 23 27
    // 31 44 33 34 35 24 37
    // 41 45 46 36 26 25 47
    // 51 52 53 54 55 56 57

    // ================================Leetcode
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    public static int removeDuplicates(int[] nums) {
        int size = nums.length;
        int index = 0;// index to store the unique elemments

        int prev = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];

            if (curr != prev) {
                nums[index] = curr;
                index++;
            } else {
                size--;
            }
            prev = curr;

        }

        return size;
    }

    public static int removeDuplicatesRec(int[] nums, int idx, int prev, int size, int index) {

        if (idx == nums.length) {
            return size;
        }

        int curr = nums[idx];
        if (prev != curr) {
            nums[index] = curr;
            index++;
        } else {
            size--;
        }
        prev = curr;

        return removeDuplicatesRec(nums, idx + 1, prev, size, index);

    }

    public static void printAllSubArrays(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void printAllSubArraysRec(int arr[], int i, int j, int k) {
        if (i == arr.length || j == arr.length || k > j) {
            return;
        }

        // Complete the fuction

    }

    // maxSubArrayRec
    public static int maxSubArrayRec(int arr[], int maxSum, int currentSum, int idx) {
        if (idx == arr.length) {
            return maxSum;
        }

        currentSum = currentSum + arr[idx];

        if (maxSum < currentSum) {
            maxSum = currentSum;
        }

        if (currentSum < 0) {
            currentSum = 0;
        }

        return maxSubArrayRec(arr, maxSum, currentSum, idx + 1);
    }

    public static void printSubSet(int arr[]) {

        int sets = (int) Math.pow(2, arr.length);

        for (int i = 0; i < sets; i++) {
            int currSet = i;

            for (int idx = 0; idx < arr.length; idx++) {

                int bit = currSet % 2;

                if (bit == 1) {
                    System.out.print(arr[idx] + " ");
                }

                currSet = currSet / 2;
            }

            System.out.println();
        }
    }

    public static void printSubSetRec(int arr[], int idx, String asf) {
        if (idx == arr.length) {
            System.out.println(asf);
            return;
        }

        printSubSetRec(arr, idx + 1, asf);
        printSubSetRec(arr, idx + 1, asf + arr[idx]);
    }

    // [1, 2, 3, 5] ans=4
    public static int missinNum(int arr[]) {

        int n = arr.length;

        int ans[] = new int[n + 1];// 0,0,0,0,0

        // feel the ans array to the position elements
        for (int i = 0; i < n; i++) {
            int pos = arr[i];
            ans[pos - 1] = pos;
        }

        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == 0) {
                return i + 1;
            }
        }
        return -1;
    }

    // GFG
    // ================https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1?page=1&category=Arrays&difficulty=Easy&sortBy=submissions
    public static ArrayList<Integer> leaders(int arr[]) {
        // code here

        return leaderRec(arr, 0);

    }

    public static ArrayList<Integer> leaderRec(int arr[], int idx) {
        if (idx == arr.length - 1) {
            ArrayList<Integer> baseAns = new ArrayList<>();
            baseAns.add(arr[idx]);
            return baseAns;
        }

        ArrayList<Integer> smallAns = leaderRec(arr, idx + 1);

        int currEle = arr[idx];

        boolean isLeader = true;

        if (currEle < smallAns.get(0)) {
            isLeader = false;
        }

        if (isLeader == true) {
            smallAns.add(0, currEle);
        }

        return smallAns;
    }

    /// find first and the last positiion from the sorted array
    ///
    /// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

    // 5,7,7,8,8,10
    public static int[] searchRange(int[] nums, int target) {

        int n = nums.length;

        int firstIndex = -1;

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            // 8<7
            if (target < nums[mid]) {
                end = mid - 1;

            } else if (target == nums[mid]) {
                end = mid - 1;
                firstIndex = mid;
            } else {
                start = mid + 1;
            }
        }

        start = 0;
        end = n - 1;

        // 5,7,7,8,8,10
        int lastIndex = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            // 8<7
            if (target < nums[mid]) {
                end = mid - 1;

            }
            if (target == nums[mid]) {
                start = mid + 1;
                lastIndex = mid;
            } else {
                start = mid + 1;
            }
        }

        return new int[] { firstIndex, lastIndex };

    }

    // matrix multiplication

    public ArrayList<ArrayList<Integer>> multiplyMatrix(int[][] mat1, int[][] mat2) {
        // code here

        int r1 = mat1.length;
        int c1 = mat1[0].length;

        int r2 = mat2.length;

        ArrayList<ArrayList<Integer>> ansMat = new ArrayList<>();

        for (int i = 0; i < r1; i++) {

            ArrayList<Integer> ans = new ArrayList<>();

            for (int j = 0; j < c1; j++) {

                int mul = 0;

                for (int k = 0; k < r2; k++) {

                    mul = mul + (mat1[i][k] * mat2[k][j]);

                }

                ans.add(mul);
            }
            ansMat.add(ans);

        }

        return ansMat;

    }

    public static void main(String args[]) {

        // int nums[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

        // printAllSubArrays(nums);

        // int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        // System.out.println(maxSubArrayRec(arr, Integer.MIN_VALUE, 0, 0));

        int arr[] = { 16, 17, 4, 3, 5, 2 };

        System.out.println(leaders(arr));

        // System.out.println(missinNum(arr));

        // printSubSetRec(arr, 0, "");

        // int prev = Integer.MIN_VALUE;

        // int size = nums.length;

        // System.out.println(removeDuplicatesRec(nums, 0, prev, size, 0));

        // List<List<Integer>> matrix = new ArrayList<>();

        // matrix.add(Arrays.asList(11, 12, 13, 14, 15, 16, 17));
        // matrix.add(Arrays.asList(21, 22, 23, 24, 25, 26, 27));
        // matrix.add(Arrays.asList(31, 32, 33, 34, 35, 36, 37));
        // matrix.add(Arrays.asList(41, 42, 43, 44, 45, 46, 47));
        // matrix.add(Arrays.asList(51, 52, 53, 54, 55, 56, 57));

        // shellRotate(matrix.size(), matrix.get(0).size(), 2, 3, matrix);

        // int arr[] = { 1, 2, 8, 10, 10, 12, 19};

        // int tar = 11;

        // int arr[] = { 12, -9, 76, 43, 12 };

        // System.out.println(findSecondLarge(arr));

        // int arr[] = { 0, 0, 0, 0 };

        // System.out.println(findConcecativeZeroAndOne(arr));

        // System.out.println(findFloor(arr, tar));

        // System.out.println(findFloorRec(arr, tar, 0, 0, -1));

        // int arr[] = { 1, 4, 3, -5, -4, 8, 6 };

        // System.out.println(countGreaterThanEle(arr, 4));
        // System.out.println(countGreaterThanEleWithRec(arr, 4, 0));
        // System.out.println(searchInUnsortedArray(arr, 4));
        // System.out.println(searchInUnsortedArrayWithRec(arr, 4, 0));

        // System.out.println(getMinMax(arr));

        // System.out.println(getMinMaxWithRec(arr, 0));

        // int arr1[] = { 9, 5, 4, 9 };
        // int arr2[] = { 2, 1, 4 };
        // int n1 = arr1.length;
        // int n2 = arr2.length;
        // for addition
        // int ans[] = new int[Math.max(n1, n2) + 1];

        // for substraction
        // int ans[] = new int[Math.max(n1, n2)];
        // int n3 = ans.length;

        // System.out.println(calcSumWithRec(arr1, arr2, ans, n1 - 1, n2 - 1, n3 - 1,
        // 0));

        // System.out.println(calc_Sum(arr1, arr2));

        // System.out.println(calc_sub(arr1, arr2));

        // System.out.println(calcSubWithRec(arr1, arr2, ans, n1 - 1, n2 - 1, n3 - 1,
        // 0));

        // reverseArray(arr);
    }
}