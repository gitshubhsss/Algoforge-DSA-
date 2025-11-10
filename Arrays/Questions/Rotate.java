package Questions;
import java.util.Scanner;

public class Rotate {

    public static void swap(int arr[]) {

    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void reverseArray(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the k ");
        int k = sc.nextInt();
        int arr[] = { 5, 7, 8, 4, 1, 3 };
        int n = arr.length;
        k = k % arr.length;
        if (k < 0) {
            k = k + arr.length;
        }
        // Inverse of A
        reverseArray(arr, 0, n - k - 1);// reversiong A

        // Inverse of B
        reverseArray(arr, n - k, n - 1);// reversing B

        // AB INVERSE
        reverseArray(arr, 0, n - 1);// reversing whole

        printArray(arr);

    }

}
