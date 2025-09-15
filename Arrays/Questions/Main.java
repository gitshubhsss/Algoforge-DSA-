package Questions;



public class Main {

    public static int elementsGreaterThanX(int[] arr, int x) {
        // write your code here
        int greaterElementCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > x) {
                greaterElementCount++;
            }
        }
        return greaterElementCount;
    }

    public static int findIndex(int arr[], int targetElement) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == targetElement) {
                return i;
            }
        }
        return -1;
    }

    public static void printStars(int heights[]) {
        int max = Integer.MIN_VALUE;
        int n = heights.length;
        // Find the max
        for (int i = 0; i < n; i++) {
            max = Math.max(max, heights[i]);
        }

        // Will go to each flor from the top
        int current_floor = max;

        // while (current_floor > 0) {
        // // go to every building and check if the
        // for (int i = 0; i < n; i++) {
        // int currentHeight = heights[i];
        // if (current_floor <= currentHeight) {
        // System.out.print("* ");
        // } else {
        // System.out.print(" ");
        // }
        // }
        // // prepare fo the next line
        // current_floor--;
        // System.out.println();
        // }

        for (int floor = current_floor; floor > 0; floor--) {
            for (int i = 0; i < n; i++) {
                int currentHeight = heights[i];
                if (floor <= currentHeight) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }

    public int[] sumOfTwoArrays(int[] arr1, int[] arr2) {
        int[] sumArray = new int[Math.max(arr1.length, arr2.length) + 1];

        int n1 = arr1.length;
        int n2 = arr2.length;

        int i = n1 - 1;
        int j = n2 - 1;
        int k = sumArray.length - 1;
        int carry = 0;
        while (k >= 0) {
            int csum = 0;
            if (i >= 0) {
                csum = csum + arr1[i];
            }

            if (j >= 0) {
                csum = csum + arr2[j];
            }
            k--;
        }

        return sumArray;
    }

    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);
        // System.out.println("Enter How many elements in the array");
        // int n = scn.nextInt();
        // System.out.println("Enter " + n + " Elements ");
        // int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        // arr[i] = scn.nextInt();
        // }
        // System.out.println("Enter target element");
        // int x = scn.nextInt();
        // System.out.println(findIndex(arr, x));

        int arr[] = { 3, 8, 0, 9, 4, 6 };

        printStars(arr);
    }
}
