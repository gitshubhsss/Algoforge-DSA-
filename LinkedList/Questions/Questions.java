package Questions;

import java.util.ArrayList;

class Node {

  int data;
  Node next;

  Node(int x) {
    data = x;
    next = null;
  }
}

class ListNode {

  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class Questions {

  // leetcode 206 (Reverse LL) ======================================
  public static ListNode reverseList(ListNode head) {
    ListNode prev = null;

    ListNode curr = head;

    while (curr != null) { // O(N)
      // find curr ka next
      ListNode nextNode = curr.next;

      // change connections----> point to prev node
      curr.next = prev;

      // move the pointers next iteration
      prev = curr;
      curr = nextNode;
    }

    // prev pointer is at the new head so return that point
    return prev;
  }

  // Bruit force approach -->find size -->find size-k th node -->retur the data
  // https://www.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1
  int getKthFromLastBruitForce(ListNode head, int k) {
    if (head == null) {
      return -1;
    }

    int size = 1;

    ListNode temp = head;

    while (temp.next != null) {
      size++;
      temp = temp.next;
    }

    if (k > size) {
      return -1;
    }

    int i = 0;
    int j = size - k;

    temp = head;

    while (i < j) {
      temp = temp.next;
      i++;
    }

    return temp.val;
  }

  // Slow and fast algorithm

  int getKthFromLast(ListNode head, int k) {
    // slow ptr
    ListNode slow = head;

    // fast ptr
    ListNode fast = head;

    // moving fast k steps ahead of slow
    while (k > 0) {
      if (fast == null) { /// moving k steps is not possible --> list size is smaller than k
        return -1;
      }
      fast = fast.next;
      k--;
    }

    // moving the slow and fast together until fast is at null
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow.val;
  }

  // https://leetcode.com/problems/middle-of-the-linked-list/description/

  public static ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  // generic middle of the linked list in case of even
  public static ListNode middleNodeGeneric(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
  }

  // https://leetcode.com/problems/palindrome-linked-list/F
  public boolean isPalindrome(ListNode head) {
    ListNode middleNode = middleNodeGeneric(head);

    ListNode secondHead = middleNode.next;

    middleNode.next = null;

    secondHead = reverseList(secondHead);

    ListNode ptr1 = head, ptr2 = secondHead;

    while (ptr1 != null && ptr2 != null) {
      if (ptr1.val != ptr2.val) {
        return false;
      }

      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
    }

    return true;
  }

  // https://leetcode.com/problems/reorder-list/
  public void reorderList(ListNode head) {
    ListNode dummy = new ListNode(-1);

    ListNode currDummy = dummy;

    ListNode firstHead = head;

    ListNode mid = middleNodeGeneric(head);

    ListNode secondHead = mid.next;

    secondHead = reverseList(secondHead);

    mid.next = null;

    while (firstHead != null && secondHead != null) {
      ListNode firstHeadKaNext = firstHead.next;
      firstHead.next = null;
      currDummy.next = firstHead;
      currDummy = firstHead;
      firstHead = firstHeadKaNext;

      ListNode secondHeadKaNext = secondHead.next;
      secondHead.next = null;
      currDummy.next = secondHead;
      currDummy = secondHead;
      secondHead = secondHeadKaNext;
    }

    if (secondHead == null) {
      currDummy.next = firstHead;
    }
  }

  // https://leetcode.com/problems/odd-even-linked-list/submissions/1840517437/
  public ListNode oddEvenList(ListNode head) {
    // create the dummy nodes
    ListNode oddDummy = new ListNode(-1);
    ListNode evenDummy = new ListNode(-1);

    // initialize the pointers
    ListNode curr = head;
    ListNode oddCurr = oddDummy;
    ListNode evenCurr = evenDummy;
    int pos = 1;

    while (curr != null) {
      ListNode currKaNext = curr.next;
      curr.next = null;

      if (pos % 2 == 0) {
        evenCurr.next = curr;
        evenCurr = curr;
      } else {
        oddCurr.next = curr;
        oddCurr = curr;
      }

      curr = currKaNext;

      pos++;
    }

    ListNode oddListHead = oddDummy.next;

    ListNode evenListHead = evenDummy.next;

    oddCurr.next = evenListHead;

    return oddListHead;
  }

  // https://www.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1
  Node divide(Node head) {
    // code here

    Node oddDummy = new Node(-1);
    Node evenDummy = new Node(-1);

    Node curr = head;

    Node oddCurr = oddDummy;

    Node evenCurr = evenDummy;

    while (curr != null) {
      Node currKaNext = curr.next;

      curr.next = null;

      if (curr.data % 2 == 0) {
        evenCurr.next = curr;
        evenCurr = curr;
      } else {
        oddCurr.next = curr;
        oddCurr = curr;
      }
      curr = currKaNext;
    }

    Node evenKaHead = evenDummy.next;
    Node oddKaHead = oddDummy.next;

    evenCurr.next = oddKaHead;

    return evenKaHead;
  }

  /// https://leetcode.com/problems/copy-list-with-random-pointer/
  public Node addCopyNodes(Node head) {
    Node curr = head;

    while (curr != null) {
      Node currKaNext = curr.next;

      Node copyNode = new Node(curr.data);

      // inserting in between
      curr.next = copyNode;
      copyNode.next = currKaNext;

      // move curr
      curr = currKaNext;
    }

    return head;
  }

  public void assignRandom(Node head) {
    Node curr = head;

    while (curr != null) {
      // Node copyNode = curr.next;

      // if (curr.random != null) {
      // copyNode.random = curr.random.next;
      // }

      curr = curr.next.next;
    }
  }

  public Node removeCopyList(Node head) {

    Node dummy = new Node(-1);
    Node copyCurr = dummy;

    Node curr = head;
    

    while (curr != null) {

      Node copyNode = curr.next;
      Node currKaNext = curr.next.next;

      copyCurr.next = copyNode;
      curr.next = currKaNext;

      curr = currKaNext;
      copyCurr = copyCurr.next;
    }

    return dummy.next;
  }

  public Node copyRandomList(Node head) {
    head = addCopyNodes(head);
    assignRandom(head);
    return removeCopyList(head);
  }

  //// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
  public ListNode deleteDuplicates(ListNode head) {
    ListNode curr = head;

    while (curr != null && curr.next != null) {
      if (curr.val == curr.next.val) {
        curr.next = curr.next.next;
      } else {
        curr = curr.next;
      }
    }

    return head;
  }

  /// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
  public ListNode deleteDuplicates2(ListNode head) {
    if (head == null) {
      return head;
    }
    if (head.next == null) {
      return head;
    }

    ListNode dummy = new ListNode(-1);

    ListNode currDummy = dummy;

    currDummy.next = head;

    ListNode curr = currDummy;

    while (curr.next != null && curr.next.next != null) {
      if (curr.next.val == curr.next.next.val) {
        ListNode temp = curr.next;

        int duplicateElement = curr.next.val;

        while (temp != null && temp.val == duplicateElement) {
          temp = temp.next;
        }
        curr.next = temp;
      } else {
        curr = curr.next;
      }
    }

    return dummy.next;
  }

  /// https://leetcode.com/problems/linked-list-cycle/
  // broot forcce my initial approch
  public boolean hasCycleBruit(ListNode head) {
    ListNode curr = head;
    ArrayList<ListNode> nodes = new ArrayList<ListNode>();
    while (curr != null) {
      if (!nodes.contains(curr)) {
        nodes.add(curr);
      } else {
        return true;
      }
      curr = curr.next;
    }
    return false;
  }

  // https://leetcode.com/problems/linked-list-cycle/ with Floyd–Warshall
  public boolean hasCycle(ListNode head) {
    if (head == null && head.next == null) {
      return false;
    }

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  /// https://leetcode.com/problems/linked-list-cycle-ii/ Floyd–Warshall
  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        break;
      }
    }

    if (slow != fast) {
      return null;
    }

    slow = head;

    while (slow != fast) {
      // moving one pointers at a time
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }

  // https://leetcode.com/problems/delete-node-in-a-linked-list/
  public void deleteNode(ListNode node) {
    ListNode nodeKaNext = node.next;
    node.next = node.next.next;
    node.val = nodeKaNext.val;
  }

  /// https://leetcode.com/problems/intersection-of-two-linked-lists/

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode temp = headB;
    while (temp.next != null) {
      temp = temp.next;
    }

    ListNode tailB = temp;

    tailB.next = headB; // or Head A

    ListNode intersectionNode = detectCycle(headA); // if the tail is connected to headA here then send head B

    tailB.next = null; // Fixing the list again

    return intersectionNode;
  }

  // https://leetcode.com/problems/merge-two-sorted-lists/?envType=problem-list-v2&envId=linked-list
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(-15565);

    ListNode currDummy = dummy;

    while (list1 != null && list2 != null) {
      if (list1.val > list2.val) {
        currDummy.next = list2;
        list2 = list2.next;
      } else {
        currDummy.next = list1;
        list1 = list1.next;
      }

      currDummy = currDummy.next;
    }

    if (list2 == null) {
      currDummy.next = list1;
    }

    if (list1 == null) {
      currDummy.next = list2;
    }

    return dummy.next;
  }

  // Leetcode 25 (Reverse nodes in k-group)
  class Solution {

    public int getSize(ListNode head) {
      ListNode temp = head;
      int size = 0;

      while (temp != null) {
        size++;
        temp = temp.next;
      }

      return size;
    }

    ListNode tHead;
    ListNode tTail;

    public void addFirst(ListNode node) {
      if (tHead == null) {
        tHead = node;
        tTail = node;
      } else {
        node.next = tHead;
        tHead = node;
      }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
      ListNode oHead = null;
      ListNode oTail = null;
      tHead = null;
      tTail = null;

      int size = getSize(head);
      ListNode curr = head;

      while (size >= k) {
        int K = k;

        // remove next K nodes and make smaller list
        while (K-- > 0) {
          ListNode currKaNext = curr.next;
          curr.next = null;

          addFirst(curr);

          curr = currKaNext;
          size--;
        }

        // attach smaller (temp) list to original list
        if (oHead == null) {
          oHead = tHead;
          oTail = tTail;
        } else {
          oTail.next = tHead;
          oTail = tTail;
        }

        tHead = null;
        tTail = null;
      }

      oTail.next = curr;
      return oHead;
    }
  }

  class Node2 {

    String url;
    Node2 next;
    Node2 prev;

    public Node2(String url) {
      this.url = url;
    }
  }

  // https://leetcode.com/problems/design-browser-history/

  class BrowserHistory {

    Node2 curr;

    public BrowserHistory(String homepage) {
      curr = new Node2(homepage);
    }

    public void visit(String url) {
      Node2 newNode = new Node2(url);
      curr.next = newNode;
      newNode.prev = curr;
      curr = curr.next;
    }

    public String back(int steps) {
      while (curr.prev != null && steps > 0) {
        curr = curr.prev;
        steps--;
      }
      return curr.url;
    }

    public String forward(int steps) {
      int i = 0;

      while (curr.next != null && i < steps) {
        curr = curr.next;
        i++;
      }

      return curr.url;
    }
  }

  public ListNode getKthElement(ListNode head, int idx) {
    ListNode curr = head;

    while (idx > 1) {
      curr = curr.next;
      idx--;
    }
    return curr;
  }

  /// https://leetcode.com/problems/reverse-linked-list-ii/
  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode dummy = new ListNode(-1);

    dummy.next = head;

    ListNode leftPrev = getKthElement(dummy, left);

    ListNode rightPrev = getKthElement(dummy, right + 1);

    ListNode leftNext = leftPrev.next;

    ListNode rightNext = rightPrev.next;

    leftPrev.next = null;
    rightPrev.next = null;

    ListNode leftSideKaHead = reverseList(leftNext);

    leftPrev.next = leftSideKaHead;
    leftNext.next = rightNext;

    return dummy.next;
  }

  public static void main(String[] args) {}
}
