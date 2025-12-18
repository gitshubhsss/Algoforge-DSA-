#include <bits/stdc++.h>

// Leecode 206===================================================>
ListNode *reverseList(ListNode *head)
{
    ListNode *prev = nullptr;
    ListNode *curr = head;

    while (curr != nullptr)
    {
        // find curr ka next and save it

        ListNode *nextNode = curr->next;
        // change connections----> point to prev node
        curr->next = prev;

        prev = curr;
        curr = nextNode;
    }

    return prev;
}

// https://www.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1

int getKthFromLast(ListNode *head, int k)
{

    // slow ptr
    ListNode *slow = head;

    // fast ptr
    ListNode *fast = head;

    // moving fast k steps ahead of slow
    while (k > 0)
    {
        if (fast == nullptr)
        { /// moving k steps is not possible --> list size is smaller than k
            return -1;
        }
        fast = fast.next;
        k--;
    }

    // moving the slow and fast together until fast is at null
    while (fast != nullptr)
    {

        slow = slow.next;
        fast = fast.next;
    }
    return slow.val;
}

int main()
{

    return 0;
}