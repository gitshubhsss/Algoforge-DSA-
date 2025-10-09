public class PrintArray {

    public static void printArray(int arr[], int idx) {
        // base case
        if (idx == arr.length) {
            return;
        }
        // prin the current index
        System.out.println(arr[idx]);

        // faith:it will print the idx+1 till n-1;
        printArray(arr, idx + 1);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 19, 4, 3, 6 };
        printArray(arr, 0);
    }
}