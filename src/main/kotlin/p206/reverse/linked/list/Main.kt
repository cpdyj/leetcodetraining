package p206.reverse.linked.list


class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        val head = head?:return null
        var p = head
        var q = head.next
        var t :ListNode? = null
        p.next = null
        while (q!=null){
            t = q.next
            q.next = p
            p = q
            q = t
        }
        return p
    }
}

class Solution2 {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null
        val n = head.next
        head.next = null
        return go(head, n)
    }

    tailrec fun go(head: ListNode, next: ListNode?): ListNode? {
        if (next == null) return head
        val t = next.next
        next.next = head
        return go(next, t)
    }
}
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
