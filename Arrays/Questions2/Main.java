public class Main {

    public static void swapValues(int arr[], int start, int end) {
        // int startValue = arr[start];
        // int endValue = arr[end];
        // arr[start] = endValue;
        // arr[end] = startValue;


    }

    public static void main(String[] args) {
        int arr[] = { 10, 5, 9, 11, 1, 14 };
      
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int start = i;
            int end = n - i - 1;
            swapValues(arr, arr[start], arr[end]);
        }
        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }
    }
}