package Arrays.Questions;

public class TwoArrayMul {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3 };
        int[] arr2 = { 4, 5 };

        int[] ans = new int[arr1.length + arr2.length];

        int num1 = 0;
        int num2 = 0;

        for (int i = arr1.length - 1; i >= 0; i--) {
            num1 = num1 + 10 * arr1[i];// 60

        }

        for (int i = arr2.length - 1; i >= 0; i--) {
            num2 = num2 + 10 * arr2[i];

        }
        int mul = num1 * num2;

        int idx = ans.length - 1;
        while (mul > 0) {
            int last = mul % 10;
            ans[idx] = last;
            mul = mul / 10;
            idx--;
        }

        printArray(ans);

    }
}
