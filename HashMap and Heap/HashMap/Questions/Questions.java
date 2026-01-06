public class Questions {

  public static char getMaxOccuringChar(String s) {
    // code here

    HashMap<Character, Integer> map = new HashMap<>();

    int maxFre = 0;

    //traverse the tring
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (map.containsKey(ch) == false) {
        map.put(ch, 1);
      } else {
        int olderFreq = map.get(ch);
        map.put(ch, olderFreq);
      }

      maxFre = Math.max(maxFre, map.get(ch));
    }

    char ans = '\0'; //initializing with 0

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (map.get(ch) == maxFre) {
        if (ans == '\0') {
          ans = ch;
        } else if (ans > ch) {
          ans = ch;
        }
      }
    }

    return ans;
  }

  ///https://leetcode.com/problems/count-elements-with-maximum-frequency/
  public int maxFrequencyElements(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();

    int maxFreq = 0;

    for (int num : nums) {
      //checking if num is already present or not
      if (map.containsKey(num) == false) {
        map.put(num, 1);
      } else {
        int olderFreq = map.get(num);
        map.put(num, olderFreq + 1);
      }

      maxFreq = Math.max(maxFreq, map.get(num));
    }

    int ans = 0;

    for (int num : nums) {
      if (map.get(num) == maxFreq) {
        ans++;
      }
    }

    return ans;
  }

  // https://leetcode.com/problems/intersection-of-two-arrays/
  public int[] intersection(int[] nums1, int[] nums2) {
    ///making the hashmap
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int num : nums1) { //O(N)
      map.put(num, 1);
    }

    ArrayList<Integer> ans = new ArrayList<>();

    for (int num : nums2) { //O(N)
      if (map.containsKey(num) == true) { //O(1)
        ans.add(num);
        map.remove(num);
      }
    }

    int[] res = new int[ans.size()];

    for (int i = 0; i < res.length; i++) {
      res[i] = ans.get(i);
    }

    return res;
  }

  ///Using hashset
  public int[] intersectionUsingHashSet(int[] nums1, int[] nums2) {
    HashSet<Integer> set = new HashSet<>();

    for (int num : nums1) {
      set.add(num);
    }

    ArrayList<Integer> ans = new ArrayList<>();

    for (int num : nums2) {
      if (set.contains(num)) {
        ans.add(num);
        set.remove(num);
      }
    }

    int res[] = new int[ans.size()];

    for (int i = 0; i < res.length; i++) {
      res[i] = ans.get(i);
    }

    return res;
  }

  //HomeWork
  ///https://www.geeksforgeeks.org/problems/common-elements5420/1

  public static ArrayList<Integer> commonElements(int a[], int b[]) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int num : a) {
      if (map.containsKey(num) == false) {
        map.put(num, 1);
      } else {
        int olderFreq = map.get(num);
        map.put(num, olderFreq + 1);
      }
    }

    ArrayList<Integer> ans = new ArrayList<>();

    for (int num : b) {
      if (map.containsKey(num) && map.get(num) > 0) {
        int olderFreq = map.get(num);
        map.put(num, olderFreq - 1);
        ans.add(num);
      }
    }

    Collections.sort(ans);

    return ans;
  }

  //https://www.geeksforgeeks.org/problems/union-of-two-arrays3538/1?page=1&category=Hash&difficulty=Easy&sortBy=submissions
  public static ArrayList<Integer> findUnion(int[] a, int[] b) {
    // code here
    HashSet<Integer> set = new HashSet<>();

    for (int num : a) {
      if (set.contains(num) == false) {
        set.add(num);
      }
    }

    for (int num : b) {
      if (set.contains(num) == false) {
        set.add(num);
      }
    }

    ArrayList<Integer> ans = new ArrayList<>();

    for (int num : set) {
      ans.add(num);
    }

    return ans;
  }

  //https://www.geeksforgeeks.org/problems/check-if-two-arrays-are-equal-or-not3847/1?page=1&category=Hash&difficulty=Easy&sortBy=submissions
  public static boolean checkEqual(int[] a, int[] b) {
    // code here

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int num : a) {
      if (map.containsKey(num) == false) {
        map.put(num, 1);
      } else {
        int olderFreq = map.get(num);
        map.put(num, olderFreq + 1);
      }
    }

    for (int num : b) {
      if (map.containsKey(num) && map.get(num) > 0) {
        int olderFreq = map.get(num);
        map.put(num, olderFreq - 1);
      } else {
        return false;
      }
    }

    return true;
  }

  //https://www.geeksforgeeks.org/problems/frequency-of-array-elements-1587115620/1?page=1&category=Hash&difficulty=Easy&sortBy=submissions
  public List<Integer> frequencyCount(int[] arr) {
    // code here

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int num : arr) {
      if (map.containsKey(num) == false) {
        map.put(num, 1);
      } else {
        int olderFreq = map.get(num);
        map.put(num, olderFreq + 1);
      }
    }

    ArrayList<Integer> ans = new ArrayList<>();

    for (int i = 1; i <= arr.length; i++) {
      if (map.containsKey(i)) {
        ans.add(map.get(i));
      } else {
        ans.add(0);
      }
    }

    return ans;
  }

  ///https://www.geeksforgeeks.org/problems/non-repeating-character-1587115620/1?page=1&category=Hash&difficulty=Easy&sortBy=submissions
  public char nonRepeatingChar(String s) {
    // code here
    HashMap<Character, Integer> map = new HashMap<>();

    for (char c : s.toCharArray()) {
      if (map.containsKey(c) == false) {
        map.put(c, 1);
      } else {
        int olderFreq = map.get(c);
        map.put(c, olderFreq + 1);
      }
    }

    for (char c : s.toCharArray()) {
      if (map.get(c) == 1) {
        return c;
      }
    }

    return '$';
  }

  //https://leetcode.com/problems/find-common-elements-between-two-arrays/
  public int[] findIntersectionValues(int[] nums1, int[] nums2) {
    /// put the second in the map

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int num : nums2) {
      map.put(num, 1);
    }

    //traverse the first array

    ArrayList<Integer> ans = new ArrayList<>();
    int count = 0;

    for (int num : nums1) {
      if (map.containsKey(num)) {
        count++;
      }
    }
    ans.add(count);
    map.clear();

    count = 0;

    for (int num : nums1) {
      map.put(num, 1);
    }

    for (int num : nums2) {
      if (map.containsKey(num)) {
        count++;
      }
    }

    ans.add(count);

    int res[] = new int[ans.size()];

    for (int i = 0; i < res.length; i++) {
      res[i] = ans.get(i);
    }

    return res;
  }

  //https://leetcode.com/problems/longest-consecutive-sequence/
  public int longestConsecutive(int[] nums) {
    HashSet<Integer> set = new HashSet<>();

    for (int ele : nums) {
      set.add(ele);
    }
    int maxLength = 0;

    for (int ele : nums) {
      int left = ele - 1;
      int right = ele + 1;

      while (set.contains(left)) {
        set.remove(left);
        left--;
      }

      while (set.contains(right)) {
        set.remove(right);
        right++;
      }

      maxLength = Math.max(maxLength, right - left - 1);
    }

    return maxLength;
  }

  public static void main(String args) {}
}
