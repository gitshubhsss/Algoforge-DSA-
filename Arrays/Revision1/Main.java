
import java.util.Scanner;

public class Main {

    public static int[] inverseArray(int[] arr) {
        int inverse[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int pos = arr[i];
            inverse[pos] = i;
        }
        return inverse;
    }

    public static int[] subtractTwoArrays(int[] arr1, int[] arr2) {

        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] ans = new int[Math.max(n1, n2)];

        // initialize the pointers
        // 10
        // 9

        int i = n1 - 1;
        int j = n2 - 1;
        int k = ans.length - 1;
        int borrow = 0;
        while (k >= 0) {
            int sub = 0;
            int digit1 = i >= 0 ? arr1[i] : 0;

            int digit2 = j >= 0 ? arr2[j] : 0;
            sub = digit1 - borrow;//

            if (digit1 < digit2) {
                sub = digit1 + 10 - digit2;// 0
                borrow = 1;
            } else {
                sub = sub - digit2;
                borrow = 0;
            }

            ans[k] = sub;
            i--;
            j--;
            k--;

        }

        return ans;
    }

    public static int[] addArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int ans[] = new int[Math.max(n1, n2) + 1];
        // initailize the pointers
        int i = n1 - 1;
        int j = n2 - 1;
        int k = ans.length - 1;
        int borrow = 0;// carry

        while (k >= 0) {
            int sum = 0;
            // check the index is valid or not
            if (i >= 0) {
                sum = sum + arr1[i];
            }

            // check if the index is valid or not
            if (j >= 0) {
                sum = sum + arr2[j];
            }

            sum = sum + borrow;

            if (sum > 9) {
                sum = sum % 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            ans[k] = sum;

            i--;
            j--;
            k--;
        }
        return ans;
    }

    // print the buidlings
    public static void printBuildingHeights(int heights[]) {
        // find the max
        int n = heights.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (max < heights[i]) {
                max = heights[i];
            }
        }
        int current_floor = max;
        while (current_floor > 0) {
            for (int i = 0; i < n; i++) {
                if (current_floor <= heights[i]) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
            current_floor--;
        }
    }

    // accept array
    public static int[] takeArrayInput() {
        Scanner scn = new Scanner(System.in);
        System.out.println("What should be the size of array?");
        int size = scn.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter values for your array");
        for (int idx = 0; idx < size; idx++) {
            int input = scn.nextInt();
            arr[idx] = input;
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void main(String[] args) {
        int[] arr1 = takeArrayInput();
        inverseArray(arr1);

    }
}