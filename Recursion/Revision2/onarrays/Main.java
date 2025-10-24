package onarrays;

public class Main {

    public static void printArray(int arr[], int idx) {

        if (idx == arr.length) {
            return;
        }

        System.out.println(arr[idx]);

        printArray(arr, idx + 1);
    }

    public static void printArrayReverse(int arr[], int idx) {

        if (idx == arr.length) {
            return;
        }

        printArrayReverse(arr, idx + 1);

        System.out.println(arr[idx]);

    }

    public static int findMax(int arr[], int idx) {
        if (idx == arr.length) {
            return -1;// you can return Integer.MIN_VALUE;
        }

        int maxSofar = findMax(arr, idx + 1);

        // compare with current element
        int max = Math.max(arr[idx], maxSofar);

        return max;
    }

    public static int findFtarIdx(int arr[], int idx, int tar) {

        if (idx == arr.length) {
            return -1;// element is not present in the array
        }

        int indexSoFar = findFtarIdx(arr, idx + 1, tar);

        if (arr[idx] == tar) {
            return idx;
        } else {
            return indexSoFar;
        }
    }

    public static int findLtarIdx(int arr[], int tar, int idx) {
        if (idx == arr.length) {
            return -1;
        }

        int lastIndex = findLtarIdx(arr, tar, idx + 1);

        if (lastIndex == -1 && arr[idx] == tar) {
            return idx;
        } else {
            return lastIndex;
        }
    }

    public static int[] findAllTarElements(int arr[], int tar, int idx, int csf) {

        if (idx == arr.length) {
            return new int[csf];
        }

        int ans[];

        if (arr[idx] == tar) {
            ans = findAllTarElements(arr, tar, idx + 1, csf + 1);
            ans[csf] = idx;
        } else {
            ans = findAllTarElements(arr, tar, idx + 1, csf);
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, 8, 4, 6, 4 };
        int idx = 0;
        int tar = 4;
        // printArray(arr, idx);
        // printArrayReverse(arr, idx);
        // System.out.println(findMax(arr, idx));
        // System.out.println(findFtarIdx(arr, idx, tar));
        // System.out.println(findLtarIdx(arr, tar, idx));

        // int indexes[] = findAllTarElements(arr, tar, idx, 0);

        // printArray(indexes, idx);

    }
}
