public class Questions {

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

  ///Solid principles
  //clean architeture
  //mvc
  //mvvm
  //method channels
  //blootooth configuration
  public static void main(String[] args) {
    //String str = "nayan";
    //System.out.println(checkPalindrome(str));
    // String str = "aabccddddeeffzzaaa";
    //  System.out.println(compressStringWithCount(str));

    int arr[]={3,5,8,1,4};
    System.out.println(sumOfLandSl(arr));
  }
}
