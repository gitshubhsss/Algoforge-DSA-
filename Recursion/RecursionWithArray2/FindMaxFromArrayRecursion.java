public class FindMaxFromArrayRecursion {

    public static int findMax(int arr[], int idx) {

        if (idx == arr.length) {
            return Integer.MIN_VALUE;
        }
        int smallerAns = findMax(arr, idx + 1);
        int ans = Math.max(smallerAns, arr[idx]);

        return ans;
    }

    public static void main(String args[]) {
        int arr[] = { 10, 19, 4, 3, 6 };

        System.out.println(findMax(arr, 0));

    }
}
