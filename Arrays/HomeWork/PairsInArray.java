package Arrays.HomeWork;

public class PairsInArray {
    public static void main(String[] args) {
        int arr[] = { 8, 12, 16, 4, 0 };

        int i = 0;
        while (i < arr.length) {
            int current = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (current - arr[j] == 4 || current - arr[j] == -4) {
                    System.out.print("( " + current + "," + arr[j] + " )");
                }
            }
            // print next line
            i++;
            System.out.println();
        }
    }
}
