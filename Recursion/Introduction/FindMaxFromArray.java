public class FindMaxFromArray {

    public static int findMax(int arr[], int idx) {

        // TODO Solve it for a small problem
        if (idx <= 0) {
            return arr[0];
        }

        // My faith is that it will work properly for the n-1 element
        int largest = findMax(arr, idx - 1);
        /// now i have to compare the lasset with the last element
        return Math.max(largest, arr[idx]);
    }

    public static int findTargetIndex(int arr[], int target, int i) {

        if (i >= arr.length) {
            return -1;
        }
        int index = findTargetIndex(arr, target, i + 1);
        if (arr[i] == target) {
            if (i > index) {
                return i;
            }
        }
        return index;

    }

    public static void main(String[] args) {
        int target = 9;
        int arr[] = { 3, 9, 7, 9 };
        // System.out.println(findMax(arr, arr.length - 1));
        System.out.println(findTargetIndex(arr, target, 0));
    }
}
