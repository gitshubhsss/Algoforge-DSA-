package Questions;

public class TwoArraySum {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 && arr[i] == 0)
                continue;
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 1 };
        int[] arr2 = { 2 };
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] arrSum = new int[Math.max(n1, n2) + 1];

        int i = n1 - 1;
        int j = n2 - 1;
        int k = arrSum.length - 1;
        int carry = 0;

        while (k >= 0) {

            int csum = 0;
            // if (i >= 0) {
            // csum = csum + arr1[i];
            // }

            // if (j >= 0) {
            // csum = csum + arr2[j];
            // }
            csum = i >= 0 ? csum + arr1[i] : 0;
            csum = j >= 0 ? csum + arr2[j] : csum;
            // adding the carry
            csum = csum + carry;
            if (csum > 9) {
                int temp = csum;
                csum = csum % 10;
                carry = temp / 10;
            } else {
                carry = 0;
            }
            arrSum[k] = csum;
            i--;
            j--;
            k--;
        }
        printArray(arrSum);

    }
}
