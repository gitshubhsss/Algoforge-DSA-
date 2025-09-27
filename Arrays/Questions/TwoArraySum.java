package Arrays.Questions;

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
        int borrow = 0;

        while (k >= 0) {

            int csum = 0;
            csum = i >= 0 ? csum + arr1[i] : 0;
            csum = j >= 0 ? csum + arr2[j] : csum;
            // adding the borrow
            csum = csum + borrow;
            if (csum > 9) {
                int temp = csum;
                csum = csum % 10;
                borrow = temp / 10;
            } else {
                borrow = 0;
            }
            arrSum[k] = csum;
            i--;
            j--;
            k--;
        }
        printArray(arrSum);

    }
}
