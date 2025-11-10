package Questions;


public class Reverse {
    public static void main(String[] args) {

        int arr[] = { 5, 4, 2, 7, 8 };
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        // jabtak start aur end cross nahi hote swap karvavo method 1
        // while (start < end) {
        // int temp = arr[start];
        // arr[start] = arr[end];
        // arr[end] = temp;
        // start++;
        // end--;
        // }

        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }

        // method 2
        // 0 ---->n-1-0
        // 1 ---->n-1-1;

        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
