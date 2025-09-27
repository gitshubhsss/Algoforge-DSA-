package Arrays.Revision2;

public class PrintSubsets {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };

        int totalSubsets = (int) Math.pow(2, arr.length);// Total subsets
        int n = arr.length;
        int i = 0;
        while (i < totalSubsets) {
            int temp = i;
            String subSet = "";
            for (int idx = n - 1; idx >= 0; idx--) {
                if (temp % 2 == 1) {
                    subSet = subSet + arr[idx];
                } else {
                    subSet = subSet + "_";
                }
                temp = temp / 2;
            }
            System.out.println(subSet);
            i++;
        }
    }
}
