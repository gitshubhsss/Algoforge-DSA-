package Arrays.BinarySearchAndIntroductionToTwoDArrays;

import java.util.Scanner;

public class Main {

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
        scn.close();
        return arr;
    }

    // print array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static int[] findFloorAndCiel(int arr[], int target) {
        int n = arr.length;
        int si = 0;
        int ei = n - 1;
        int floor = Integer.MIN_VALUE;// -
        int ciel = Integer.MAX_VALUE;// +
        int ans[] = new int[2];
        // 13,14,18
        // int arr[] = {1,7,9,13,18,23,35 };//7
        while (si <= ei) {
            int mid = (si + ei) / 2;// 4+7/24
            if (arr[mid] == target) {
                break;
            }
            if (arr[mid] < target) {
                floor = arr[mid];// 13 ji middle vali value aahe ti chotia aahe mhanaje ti fllor
                si = mid + 1;// 4
            } else {
                ciel = arr[mid];// 23 jat ti mothi asel tr//23//18
                ei = mid - 1;// 3
            }
        }
        ans[0] = floor;
        ans[1] = ciel;
        System.out.println("floor is " + floor);
        System.out.println("ciel is " + ciel);
        return ans;
    }

    public static int binarySearch(int arr[], int target) {
        int n = arr.length;
        int si = 0;
        int ei = n - 1;
        int start = -1;
        int end = -1;
        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (arr[mid] == target) {
                end = mid;

                return mid;
            }
            if (arr[mid] < target) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        System.out.println("start " + start);
        System.out.println("end " + end);
        return -1;
    }

    // Leetcode Question Log n madhe solve karayachat
    public static int[] findFirstAndLastIndex(int arr[], int target) {
        int n = arr.length;
        int si = 0;
        int ei = n - 1;
        // 1, 2, 2, 3, 3, 5, 5, 5, 6, 11, 14, 19, 19, 28
        //target is 5
        int firstIndex = -1;
        while (si <= ei) {
            // find mid
            int mid = (si + ei) / 2;
            if (arr[mid] == target) {
                //Going towards left cause we want to find the first index 
                firstIndex = mid;
                ei = mid - 1;
            } else if (arr[mid] < target) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        int lastIndex = -1;
        si = 0;
        ei = n - 1;
        while (si <= ei) {
            // find mid
            int mid = (si + ei) / 2;
            if (arr[mid] == target) {
                //going towards right cause we want to find the last index
                lastIndex = mid;
                si = mid + 1;
            } else if (arr[mid] < target) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        return new int[] { firstIndex, lastIndex };
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 3, 3, 5, 5, 5, 6, 11, 14, 19, 19, 28 };
        int target = 3;
        binarySearch(arr, target);

    }
}