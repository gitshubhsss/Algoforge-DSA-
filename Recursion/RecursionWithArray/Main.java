public class Main {

    public static void printReverse(int arr[], int idx) {
        if (idx >= arr.length) {
            return;
        }

        printReverse(arr, idx + 1);
        System.out.println(arr[idx]);

    }

    public static void printArray(int arr[], int idx) {
        // base case solve for the smaller problem
        if (idx >= arr.length) {
            return;
        }
        System.out.println(arr[idx]);
        // faith it will work properly for (n-1 )value here means we are printing 1 to
        // n-1 value
        printArray(arr, idx + 1);
    }

    public static int findMax(int arr[], int idx) {
        // base case
        if (idx == arr.length - 1) {
            return arr[idx];
        }
        // Faith: it will return the max from index 1 to n-1
        int smallerAns = findMax(arr, idx + 1);
        // now i have to compare with my idx
        int ans = Math.max(smallerAns, arr[idx]);
        return ans;
    }

    // find the first index
    public static int findFirstIndex(int arr[], int tar, int idx) {
        if (idx == arr.length) {
            return -1;
        }

        // faith:it will search from idx+1 to n-1;
        int smallAns = findFirstIndex(arr, tar, idx + 1);
        if (arr[idx] == tar) {
            // return aaj wala index
            return idx;
        }
        // nahitar thr
        return smallAns;
    }

    // find the last index
    public static int findLastIndex(int arr[], int tar, int idx) {
        if (idx == arr.length) {
            return -1;
        }
        // faith:it will search from idx+1 to n-1;
        int fle = findLastIndex(arr, tar, idx + 1);

        if (fle == -1 && arr[idx] == tar) {
            return idx;
        }
        return fle;
    }

    // Find all the indices
    public static int[] findAllIndices(int[] arr, int tar, int idx, int fsf) {
        if (idx == arr.length) {
            int baseArray[] = new int[fsf];
            return baseArray;
        }
        int ans[];
        if (arr[idx] == tar) {
            ans = findAllIndices(arr, tar, idx + 1, fsf + 1);
        } else {
            ans = findAllIndices(arr, tar, idx + 1, fsf);
        }
        if (arr[idx] == tar) {
            ans[fsf] = idx;
        }
        return ans;
    }

    public static void main(String args[]) {

        int arr[] = { 10, 19, 4, 4, 53, 6, 4 };
        // int idx = 0;
        // printReverse(arr, idx);

        // System.out.println(findLastIndex(arr, 4, 0));

        int ans[] = findAllIndices(arr, 4, 0, 0);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}