public class PrintSubArray {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 8, 10, 11, 12, 19 };

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }

    }
}