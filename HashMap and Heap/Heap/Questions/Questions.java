import java.util.*;

public class Questions {

  //https://leetcode.com/problems/kth-largest-element-in-an-array/
  public int findKthLargestTemp(int[] nums, int k) {
    PriorityQueue<Integer> minPQ = new PriorityQueue<>();

    for (int ele : nums) {
      if (minPQ.size() < k) {
        minPQ.add(ele);
      } else {
        int topEle = minPQ.peek();
        if (topEle < ele) {
          minPQ.poll();
          minPQ.add(ele);
        }
      }
    }

    return minPQ.peek();
  }

  //https://leetcode.com/problems/kth-largest-element-in-an-array/
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minPQ = new PriorityQueue<>();
    for (int ele : nums) {
      minPQ.add(ele);
      if (minPQ.size() > k) {
        minPQ.remove();
      }
    }
    return minPQ.peek();
  }

  ///Home work 1
  ///https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1

  ///Sort k sorted array(https://www.geeksforgeeks.org/problems/nearly-sorted-1587115620/1)

  public void nearlySorted(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    int idx = 0;

    for (int ele : arr) {
      pq.add(ele);

      if (pq.size() > k) {
        arr[idx] = pq.peek();
        pq.remove();
        idx++;
      }
    }

    while (pq.size() > 0) {
      arr[idx] = pq.peek();
      pq.remove();
      idx++;
    }
  }

  //HomeWork 2
  //https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1

  //Leetcode 23 https://leetcode.com/problems/merge-k-sorted-lists/
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>(
      (ListNode a, ListNode b) -> {
        return a.val - b.val;
      }
    );

    for (ListNode head : lists) {
      if (head != null) {
        pq.add(head);
      }
    }

    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;

    while (pq.size() > 0) {
      ListNode top = pq.remove();

      ListNode topKaNext = top.next;

      top.next = null;
      if (topKaNext != null) {
        pq.add(topKaNext);
      }

      curr.next = top;
      curr = curr.next;
    }

    return dummy.next;
  }

  public static void main(String args[]) {
    System.out.println("Question is working fine");
  }
}
