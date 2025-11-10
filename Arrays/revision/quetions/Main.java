import java.util.ArrayList;

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

    public static void main(String args[]) {
        int arr[] = { 1, 23, 4 };

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

        reverseArray(arr);
    }
}