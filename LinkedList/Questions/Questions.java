package Questions;

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
    public ListNode reverseList(ListNode head) {

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

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // generic middle of the linked list in case of even
    public ListNode middleNodeGeneric(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }


    //https://leetcode.com/problems/palindrome-linked-list/F
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

    public static void main(String[] args) {

    }
}