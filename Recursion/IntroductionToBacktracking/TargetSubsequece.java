public class TargetSubsequece {

    public static void printTargetSubsequecce(int arr[], int tar, int idx, String asf) {
        if (tar < 0) {
            return;
        }
        if (idx == arr.length) {
            if (tar == 0) {
                System.out.println(asf);
            }
            return;
        }

        // yes call
        printTargetSubsequecce(arr, tar - arr[idx], idx + 1, asf + arr[idx]);

        // no call
        printTargetSubsequecce(arr, tar, idx + 1, asf);
    }

    public static void main(String strgs[]) {
        int arr[] = { 2, 5, 3, 1, 4, 6, -8 };
        int tar = 8;
        printTargetSubsequecce(arr, tar, 0, "");
    }
}
