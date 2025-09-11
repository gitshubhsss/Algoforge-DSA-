package Questions;

public class TwoArraySub {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 && arr[i] == 0)
                continue;
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 5, 0, 0 };
        int[] arr2 = { 2, 5, 0 };
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] arrSum = new int[Math.max(n1, n2)];

        int i = n1 - 1;
        int j = n2 - 1;
        int k = arrSum.length - 1;
        int borrow = 0;

        while (k >= 0) {
            int digit1 = i >= 0 ? arr1[i] : 0;
            int digit2 = j >= 0 ? arr2[j] : 0;
            int curr = digit1 - borrow;
            if (curr < digit2) {
                curr = curr + 10 - digit2;
                borrow = 1;
            } else {
                curr = curr - digit2;
                borrow = 0;
            }
            arrSum[k] = curr;
            k--;
            j--;
            i--;
        }

        printArray(arrSum);

    }
}
