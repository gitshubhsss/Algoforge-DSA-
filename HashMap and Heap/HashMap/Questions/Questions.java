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

    for (int num : nums1) {
      //O(N)
      map.put(num, 1);
    }

    ArrayList<Integer> ans = new ArrayList<>();

    for (int num : nums2) {
      //O(N)
      if (map.containsKey(num) == true) {
        //O(1)
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

  //https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
  //Dryrun-Done
  public static int maxLength(int arr[]) {
    // code here
     int maxLength(int arr[]) {
        // code here
        
        HashMap<Integer,Integer>map=new HashMap<>();
        
        map.put(0,-1);
        
        int ans=0;
        
        int currSum=0;
        
        for(int i=0;i<arr.length;i++){
            
            currSum=currSum+arr[i];//1
            
            if(map.containsKey(currSum)==false){
        
                map.put(currSum,i);
        
            }else{
                
                int len=i-map.get(currSum);
                
                ans=Math.max(ans,len);
            }
        }
        
        return ans;
        
    }
  }
//https://www.geeksforgeeks.org/problems/zero-sum-subarrays1825/1
//Dryrun-Done
    public int findSubarray(int[] arr) {
        
        HashMap<Integer,Integer>map=new HashMap<>();
        
        int cSum=0;
        
        map.put(cSum,1);
        
        int ans=0;
        
        for(int i=0;i<arr.length;i++){
            
            cSum=cSum+arr[i];
            
            if(map.containsKey(cSum)){
                int oldFreq=map.get(cSum);
                map.put(cSum,oldFreq+1);
                ans=ans+oldFreq;
            }else{
                map.put(cSum,1);
            }
        }
        
        return ans;
        
    }
//https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
//Dryrun-DONE
     public int longestSubarray(int[] arr, int k) {
        // code here
        
        HashMap<Integer,Integer>map=new HashMap<>();
        
        int cSum=0;
        
        map.put(cSum,-1);
        
        int ans=0;
        
        for(int i=0;i<arr.length;i++){
            
            cSum=cSum+arr[i];
            
            if(map.containsKey(cSum-k)){
          
                ans=Math.max(ans,i-map.get(cSum-k));
                
            }
            
            if(map.containsKey(cSum)==false){
                 map.put(cSum,i);
            }
    
        }
        
        return ans;
    }

    //https://leetcode.com/problems/subarray-sum-equals-k/
    //Code pending

     public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int cSum = 0;

        map.put(cSum, 1);

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            cSum = cSum + nums[i];

            if (map.containsKey(cSum - k)) {
                int oldFreq = map.get(cSum - k);
                map.put(cSum, oldFreq + 1);
                ans = ans + oldFreq;
            } else {
                map.put(cSum, 1);
            }
        }

        return ans;

    }

//https://leetcode.com/problems/subarray-sums-divisible-by-k/
//DryRun - Pending
     public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cSum = 0;
        map.put(cSum, 1);

        int count = 0;

        for (int e : nums) {

            cSum += e;
            int rem = cSum % k;
            if (rem < 0) {
                rem += k;
            }

            count += map.getOrDefault(rem, 0);

            map.put(rem, map.getOrDefault(rem, 0) + 1);

        }

        return count;
    }

    //https://leetcode.com/problems/contiguous-array/description/

    public int findMaxLength(int[] nums) {
        
    }


    //https://leetcode.com/problems/insert-delete-getrandom-o1/description/

class RandomizedSet {

    ArrayList<Integer> data;
    HashMap<Integer, Integer> map;

    public RandomizedSet() {
        data = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        
        if (map.containsKey(val) == true) {
            return false;
        }

        map.put(val, data.size());
        data.add(val);

        return true;

    }

    public boolean remove(int val) {
        if (map.containsKey(val) == false) {
            return false;
        }

        int valIndex = map.get(val);

        int lastIndexValue = data.get(data.size() - 1);

        data.set(valIndex, lastIndexValue);

        map.put(lastIndexValue, valIndex);

        map.remove(val);

        data.remove(data.size() - 1);

        return true;
    }

    public int getRandom() {
        int randomIdx = (int) (Math.random() * data.size());
        return data.get(randomIdx);
    }
}

//https://leetcode.com/problems/lru-cache/
class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void addLast(Node nn) {
        if (head == null) {
            head = tail = nn;
        } else {
            tail.next = nn;
            nn.prev = tail;
            tail = nn;
        }
        size++;
    }

    public void removeFirst() { // assuming it will be called only when size > maxCapactiy => size will be atleast 2
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
    }

    public void removeNode(Node toRemove) {
        if (head == tail) {
            head = null;
            tail = null;
        } else if (head == toRemove) {
            head = head.next;
            head.prev = null;
        } else if (tail == toRemove) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node toRemoveKaPrev = toRemove.prev;
            Node toRemoveKanext = toRemove.next;

            toRemoveKaPrev.next = toRemoveKanext;
            toRemoveKanext.prev = toRemoveKaPrev;
        }

        size--;
    }

    Node head;
    Node tail;
    HashMap<Integer, Node> map; // keyVsNode
    int size;
    int maxCapacity;

    public LRUCache(int capacity) {
        head = null;
        tail = null;
        map = new HashMap<>();
        size = 0;
        maxCapacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key) == false) {
            return -1;
        }

        Node nodeWithKey = map.get(key);

        removeNode(nodeWithKey);

        addLast(nodeWithKey);

        return nodeWithKey.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {//update value

            Node nodeWithKey = map.get(key);
            nodeWithKey.value = value;
            get(key);

        } else {
            Node nn = new Node(key, value);

            addLast(nn);

            map.put(key, nn);

            if (size > maxCapacity) {
                int headKey = head.key;
                removeNode(head);
                map.remove(headKey);
            }
        }
    }
}



//https://leetcode.com/problems/lfu-cache/description/

  public static void main(String args) {}
}
