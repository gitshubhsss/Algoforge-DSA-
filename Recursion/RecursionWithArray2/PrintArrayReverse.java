public class PrintArrayReverse {

    public static void printArrayReverse(int arr[], int idx) {
        // base case
        if (idx == arr.length) {
            return;
        }
        printArrayReverse(arr, idx + 1);
        System.out.println(arr[idx]);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 19, 4, 3, 6 };
        printArrayReverse(arr, 0);
    }
}
