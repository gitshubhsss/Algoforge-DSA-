public class SubArrays {
    public static void main(String[] args) {
        int arr[] = { 10, 5, 9, 4, 2 };
        int n = arr.length;
        for (int si = 0; si < n; si++) {
            for (int ei = si; ei < n; ei++) {
                // print from start to end
                for (int idx = si; idx <= ei; idx++) {
                    System.out.print(arr[idx] + " ");
                }
                System.out.println();
            }
        }
    }
}
