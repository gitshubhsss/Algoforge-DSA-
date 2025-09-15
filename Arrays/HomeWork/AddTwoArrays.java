public class AddTwoArrays {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 9, 0, 1, 2 };
        int[] arr2 = { 2, 4 };
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] ans = new int[Math.max(n1, n2) + 1];
        // initialize the pointers
        int i = n1 - 1;
        int j = n2 - 1;
        int k = ans.length - 1;
        int borrow = 0;
        while (k >= 0) {
            int currentSum = 0;
            int digit1 = i >= 0 ? arr1[i] : 0;
            int digit2 = j >= 0 ? arr2[j] : 0;
            currentSum = digit1 + digit2 + borrow;
            if (currentSum > 9) {
                int temp = currentSum;
                currentSum = currentSum % 10;
                borrow = temp / 10;
            } else {
                borrow = 0;
            }
            ans[k] = currentSum;
            i--;
            j--;
            k--;

        }
        printArray(ans);
        
    }
}
