package HomeWork;

public class SubstractTwoArrays {

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
        int[] ans = new int[arr1.length];

        // initialize the pointers
        int i = n1 - 1;
        int j = n2 - 1;
        int k = ans.length - 1;
        int borrow = 0;
        while (k >= 0) {
            
            int sub = 0;
            int digit1 = i >= 0 ? arr1[i] : 0;
            int dight2 = j >= 0 ? arr2[j] : 0;
            // first subtract the borrow
            digit1 = digit1 - borrow;
            // if the first digit is smaller than the second digit will add the
            // will add 10 in the fist dight and then will subtract the second digit and
            // will put the borow value as 1
            if (digit1 < dight2) {
                sub = digit1 + 10 - dight2;
                borrow = 1;
            } else {
                // if the digit one is greater than or equal to the dight 2 will subtract
                // directly no boow
                sub = digit1 - dight2;
                borrow = 0;
            }

            ans[k] = sub;

            i--;
            j--;
            k--;
        }

        printArray(ans);

    }
}