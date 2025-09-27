package Arrays.Questions;

public class SpanMax {

    public static int findSpanMax(int arr[]) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            // if (arr[i] > max) {
            // max = arr[i];
            // }
            max = Math.max(max, arr[i]);
            // if (arr[i] < min) {
            // min = arr[i];
            // }
            min = Math.min(min, arr[i]);
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        int span = max - min;
        return span;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 3, 4, 11, 9, 2 };

        System.out.println(findSpanMax(arr));
    }
}
