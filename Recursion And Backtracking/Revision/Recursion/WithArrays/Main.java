public class Main {

  public static void printArray(int arr[], int idx) {
    if (idx == arr.length) {
      return;
    }

    System.out.print(arr[idx] + " ");
    printArray(arr, idx + 1);
  }

  public static void printArrayInReverse(int arr[], int idx) {
    if (idx == arr.length) {
      return;
    }

    printArrayInReverse(arr, idx + 1);
    System.out.print(arr[idx] + " ");
  }

  //Find max element in array using recursion

  public static int findMax(int arr[], int idx) {
    if (idx == arr.length) {
      return -1;
    }

    int maxSoFar = findMax(arr, idx + 1);

    return Math.max(arr[idx], maxSoFar);
  }

  //Find first index of a target element

  public static int findFirstIndex(int arr[], int idx, int tar) {
    if (idx == arr.length) {
      return -1;
    }

    int indexSoFar = findFirstIndex(arr, idx + 1, tar);

    if (arr[idx] == tar) {
      return idx;
    } else {
      return indexSoFar;
    }
  }

  //Find last index of a target element, initial input in function will be idx = 0
  public static int findLastIndex(int arr[], int idx, int tar) {
    if (idx == arr.length) {
      return -1;
    }

    int indexSoFar = findLastIndex(arr, idx + 1, tar);

    if (indexSoFar == -1 && arr[idx] == tar) {
      return idx;
    }

    return indexSoFar;
  }

  //Return an array consisting of all indices of target element
  //10, 23, 32, 32, 1, 4, 23
  public static int[] findAllIndices(
    int arr[],
    int tar,
    int idx,
    int indexSoFar
  ) {
    if (idx == arr.length) {
      //create a new array
      int baseAns[] = new int[indexSoFar];
      return baseAns;
    }

    int ans[];

    if (arr[idx] == tar) {
      ans = findAllIndices(arr, tar, idx + 1, indexSoFar + 1);
      ans[indexSoFar] = idx;
    } else {
      ans = findAllIndices(arr, tar, idx + 1, indexSoFar);
    }
    return;
  }

  public static void main(String args[]) {
    //1,6
    int arr[] = { 10, 23, 32, 32, 1, 4, 23 };
    //printArray(arr, 0);
    // printArrayInReverse(arr, 0);
    // int max = findMax(arr, 0);
    // System.out.println(max);
    //  System.out.println(findFirstIndex(arr, 0, 23));
    // System.out.println(findLastIndex(arr, 0, 23));

    printArray(findAllIndices(arr, 23, 0, 0), 0);
  }
}
