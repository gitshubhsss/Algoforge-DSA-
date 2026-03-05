public class Questions {

  // Leetcode : 1582. Special Positions in a Binary Matrix
  class Solution {

    public int numSpecial(int[][] mat) {
      int n = mat.length;
      int m = mat[0].length;

      int spCount = 0;

      for (int row = 0; row < n; row++) {
        for (int col = 0; col < m; col++) {
          if (mat[row][col] == 1) {
            int count = 0;
            for (int i = 0; i < m; i++) {
              if (mat[row][i] == 1) {
                count++;
              }
            }

            for (int i = 0; i < n; i++) {
              if (mat[i][col] == 1) {
                count++;
              }
            }

            if (count == 2) {
              spCount++;
            }
          }
        }
      }

      return spCount;
    }
  }

  public static boolean checkPalindrome(String str) {
    int left = 0;
    int right = str.length() - 1;

    while (right > left) {
      if (str.charAt(left) != str.charAt(right)) {
        return false;
      }

      left++;
      right--;
    }
    return true;
  }

  //    String str = "aabccddddeeffzzaaa";
  public static String compressString(String str) {
    char prev = str.charAt(0);

    String ans = prev + "";

    for (int i = 1; i < str.length(); i++) {
      char curr = str.charAt(i);

      if (prev != curr) {
        ans = ans + curr;
      }

      prev = curr;
    }

    return ans;
  }

  //aabccddddeeffzzaaa
  public static String compressStringWithCount(String str) {
    String ans = str.charAt(0) + "";

    char prev = str.charAt(0);

    int count = 0;

    for (int i = 1; i < str.length(); i++) {
      char curr = str.charAt(i);

      if (prev == curr) {
        count++;
      } else if (count > 1) {
        ans = ans + count;
        count = 1;
        ans = ans + curr;
      }

      prev = curr;
    }

    ans = ans + count;

    return ans;
  }

  //3,5,8,1,4
  public static int sumOfLandSl(int[] arr) {
    int l = arr[0];
    int sl = 0;

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > l) {
        sl = l;
        l = arr[i];
      }
    }

    return l + sl;
  }

  public static void main(String[] args) {
    int arr[] = { 3, 5, 8, 1, 4 };
    System.out.println(sumOfLandSl(arr));
  }
}
