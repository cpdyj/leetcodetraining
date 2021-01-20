package p21;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode top;
        if (l1 == null) top = l2;
        else if (l2 == null) top = l1;
        else top = l1.val < l2.val ? l1 : l2;
        ListNode p = l1 == top ? l1.next : l1;
        ListNode q = l2 == top ? l2.next : l2;
        ListNode o = top;
        while (p != null || q != null) {
            if (q == null || (p != null && p.val < q.val)) {
                o.next = p;
                p = p.next;
            } else {
                o.next = q;
                q = q.next;
            }
            o = o.next;
        }
        return top;
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