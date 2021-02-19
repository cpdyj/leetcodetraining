package p61.rotate.list

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        var len = 0
        var tail = head ?: return head
        while (true) {
            len++
            tail = tail.next ?: break
        }
        val skip = len - k % len
        if (skip < 1) return head
        var p:ListNode = head
        repeat(skip - 1) {
            p = p.next!!
        }
        tail.next = head
        val newHead = p.next
        p.next = null
        return newHead
    }

}

