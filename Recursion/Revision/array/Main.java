package array;

public class Main {

    // function to print the array
    // smaller problem is to print the idx+1 to n-1 element
    public static void printArray(int arr[], int idx) {

        if (idx == arr.length) {
            return;
        }
        // Faith-: it will work properly for the idx+1 to n-1;
        System.out.println(arr[idx]);
        printArray(arr, idx + 1);
    }

    public static void printReverse(int arr[], int idx) {

        if (idx == arr.length) {
            return;
        }
        printReverse(arr, idx + 1);
        System.out.println(arr[idx]);
    }

    public static int findMax(int[] arr, int idx) {
        if (idx == arr.length) {
            return Integer.MIN_VALUE;
        }
        // faith:it will find the max from the idx+1 to n-1;
        int smallerAns = findMax(arr, idx + 1);
        // now i need to compare the smaller ans with my ans
        int myAns = Math.max(smallerAns, arr[idx]);
        return myAns;
    }

    public static int findFirstIndex(int[] arr, int target, int idx) {

        if (idx == arr.length) {
            return -1;
        }

        int furtherFirstIndex = findFirstIndex(arr, target, idx + 1);

        if (arr[idx] == target) {
            return idx;
        } else {
            return furtherFirstIndex;
        }
    }

    public static int findLastIndex(int[] arr, int target, int idx) {

        if (idx == arr.length) {
            return -1;
        }

        int lastIndex = findLastIndex(arr, target, idx + 1);

        if (lastIndex == -1 && arr[idx] == target) {
            return idx;
        }

        return lastIndex;

    }

    // int[] arr = {10, 4, 19, 4, 4, 4, 4, 4, 19}; //[1,3,4,5,6,7]
    public static int[] findAllIndices(int[] arr, int target, int idx, int fsf) {

        if (idx == arr.length) {
            int baseArray[] = new int[fsf];
            return baseArray;
        }

        int ans[];

        if (arr[idx] == target) {
            ans = findAllIndices(arr, target, idx + 1, fsf + 1);
            ans[fsf] = idx;

        } else {
            ans = findAllIndices(arr, target, idx + 1, fsf);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 4, 19, 4, 4, 4, 4, 4, 19 };
        int idx = 0;
        // printArray(arr, idx);
        // printReverse(arr, idx);

        // int max = findMax(arr, idx);
        // System.out.println(max);
        // int tarIndex = findFirstIndex(arr, 4, idx);
        // System.out.println(tarIndex);
        // int tarIndex = findLastIndex(arr, 4, idx);
        // System.out.println(tarIndex);
        int indices[] = findAllIndices(arr, 4, idx, 0);

        printArray(indices, 0);
    }
}
