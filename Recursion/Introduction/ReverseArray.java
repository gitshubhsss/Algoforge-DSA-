public class ReverseArray {

    // function expectatins
    public static void reverseArray(int arr[], int si, int ei) {
        // solve for the smallet problem
        if (si > ei) {
            return;
        }
        // Solve for the whole problem
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
        // faith is that it will work properly for the smaller values
        reverseArray(arr, si + 1, ei - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int si = 0;
        int ei = arr.length - 1;
        reverseArray(arr, si, ei);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
