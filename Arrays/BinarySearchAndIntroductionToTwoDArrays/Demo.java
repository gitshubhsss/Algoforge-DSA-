public class Demo {

    public static String calc_Sum(int arr1[], int arr2[]) {
        // Complete the function

        // find the lengths
        int n1 = arr1.length;
        int n2 = arr2.length;

        int ans[] = new int[Math.max(n1, n2) + 1];

        // initialize the pointers

        int i = n1 - 1;
        int j = n2 - 1;
        int k = ans.length - 1;

        int borrow = 0;
        String sumStr = "";
        while (k >= 0) {
            int sum = 0;
            if (i >= 0) {
                sum = sum + arr1[i];
            }

            if (j >= 0) {
                sum = sum + arr2[j];
            }

            sum = sum + borrow;

            if (sum > 9) {
                // take the last dight
                sum = sum % 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            System.out.println("k = " + k + " borrow =" + borrow);
            ans[k] = sum;
            if (k != 0 || ans[k] != 0) {
                sumStr = sum + "" + sumStr;
            }

            i--;
            j--;
            k--;

        }
        return sumStr;

    }

    public static void main(String[] args) {

        int arr1[] = { 8, 5, 9, 2, 4, 1, 8, 3, 9, 3, 8, 7, 8, 6, 8, 9, 4, 1 };
        int arr2[] = { 1, 7, 6, 1, 5, 8, 7, 6, 9, 6, 3, 1, 3, 1, 7, 5, 9, 2, 8 };

        System.out.println(calc_Sum(arr1, arr2));

        // 8 ,5, 9 ,2 ,4, 1, 8, 3, 9, 3 ,8 ,7, 8, 6//15, 8//16, 9//17, 4//18, 1//19
        // 1, 7, 6, 1, 5, 8, 7, 6, 9, 6, 3, 1, 3, 1, 7, 5, 9, 2, 8
    }
}
