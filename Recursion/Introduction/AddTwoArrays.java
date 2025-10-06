public class AddTwoArrays {

    public static void addTwoArrays(int arr1[], int arr2[], int ans[], int carry, int i, int j, int k) {

        if (k < 0) {
            return;
        }

        int sum = 0;
        if (i >= 0) {
            sum += arr1[i];
        }
        if (j >= 0) {
            sum += arr2[j];
        }
        sum = sum + carry;
        if (sum > 9) {
            sum = sum % 10;
            carry = 1;
        } else {
            carry = 0;
        }

        ans[k] = sum;
        i--;
        j--;
        k--;
        addTwoArrays(arr1, arr2, ans, carry, i, j, k);
    }

    public static void main(String[] args) {
        int arr1[] = { 6, 5, 3 };
        int arr2[] = { 7, 8, 5, 3 };
        int n1 = arr1.length;
        int n2 = arr2.length;
        int ans[] = new int[(int) Math.max(n1, n2) + 1];

        System.out.println(ans.length);
        // intialize the pointers
        int i = n1 - 1;
        int j = n2 - 1;
        int k = ans.length - 1;

        addTwoArrays(arr1, arr2, ans, 0, i, j, k);

        for (int idx = 0; idx < ans.length; idx++) {
            System.out.print(ans[idx]);
        }

    }
}
