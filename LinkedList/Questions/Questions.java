package Questions;

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

    ListNode() {
    }

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

        while (curr != null) {// O(N)
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
            if (fast == null) {/// moving k steps is not possible --> list size is smaller than k
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

    // https://leetcode.com/problems/merge-two-sorted-lists/?envType=problem-list-v2&envId=linked-list

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);

        ListNode currDummy = dummy;

        ListNode firstHead = list1;

        ListNode seconHead = list2;

        while (firstHead != null && seconHead != null) {

            if (firstHead.val > seconHead.val) {
                ListNode secondHeadKaNext = seconHead.next;
                seconHead.next = null;
                currDummy.next = seconHead;
                currDummy = seconHead;
                seconHead = secondHeadKaNext;

            } else {
                ListNode firstNodeKaNext = firstHead.next;
                firstHead.next = null;
                currDummy.next = firstHead;
                currDummy = firstHead;
                firstHead = firstNodeKaNext;
            }

        }

        if (firstHead == null) {
            currDummy.next = seconHead;
        }

        if (seconHead == null) {
            currDummy.next = firstHead;
        }

        return dummy.next;
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
            currDummy = firstHead;// 1K
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

    public static void main(String[] args) {

    }
}