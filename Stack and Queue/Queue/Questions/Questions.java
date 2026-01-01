public class Questions {

  //https://leetcode.com/problems/number-of-recent-calls/
  class RecentCounter {

    int t = 0;
    LinkedList<Integer> st;

    public RecentCounter() {
      this.t = 0;
      st = new LinkedList<Integer>();
    }

    public int ping(int t) {
      st.addLast(t);

      while (st.size() > 0 && st.getFirst() <= (t - 3000)) {
        st.removeFirst();
      }
      return st.size();
    }
  }

  //https://www.lintcode.com/problem/3662/
  public class HitCounter {

    public HitCounter() {}

    /**
     * @param timestamp: the timestamp
     * @return: nothing
     */
    public void hit(int timestamp) {}

    /**
     * @param timestamp: the timestamp
     * @return: the count of hits in recent 300 seconds
     */
    public int getHits(int timestamp) {}
  }

  //https://www.lintcode.com/problem/642/
  public class MovingAverage {

    /*
     * @param size: An integer
     */public MovingAverage(int size) {
      // do intialization if necessary
    }

    /*
     * @param val: An integer
     * @return:
     */
    public double next(int val) {
      // write your code here
    }
  }

  public int[] maxSlidingWindow(int[] nums, int k) {}

  //Leetcode 862
  public int shortestSubarray(int[] nums, int k) {
    int n = nums.length;

    long[] pre = new long[n];
    pre[0] = nums[0];

    for (int i = 1; i < n; i++) {
      pre[i] = pre[i - 1] + nums[i];
    }

    LinkedList<Integer> deque = new LinkedList<>();
    int ans = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      if (pre[i] >= k) {
        ans = Math.min(i + 1, ans);
      }

      // this is to shorten the array
      while (deque.size() > 0 && pre[i] - pre[deque.getFirst()] >= k) {
        ans = Math.min(ans, i - deque.getFirst());
        deque.removeFirst();
      }

      // this is to remove negative elements
      while (deque.size() > 0 && pre[i] <= pre[deque.getLast()]) {
        deque.removeLast();
      }

      deque.addLast(i);
    }

    return ans == Integer.MAX_VALUE ? -1 : ans;
  }

  public static void main(String[] args) {
    System.out.println("Hellow ");
  }
}
