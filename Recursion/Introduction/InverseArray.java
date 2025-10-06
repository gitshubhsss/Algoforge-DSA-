public class InverseArray {

    public static void inverse(int arr[], int inverseArr[], int idx) {

        // solve for the small problme

        if (idx < 0) {
            return;
        }

        // solve for the whole problem
        inverseArr[arr[idx]] = idx;

        // faith-:it will work properly for n-1 lenght
        inverse(arr, inverseArr, idx - 1);

    }

    public static void main(String[] args) {
        int arr[] = { 4, 3, 1, 0, 2 };
        int inverseArr[] = new int[arr.length];

        inverse(arr, inverseArr, arr.length - 1);

        for (int i = 0; i < inverseArr.length; i++) {
            System.out.print(inverseArr[i] + " ");
        }
    }
}
