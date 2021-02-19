package p328.odd.even.linked.list

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


class Solution {
    fun oddEvenList(head: ListNode?): ListNode? {
        val odd = ListNode(-1)
        val even = ListNode(-1)
        var oddp = odd
        var evenp = even
        var p = head ?: return null
        var b = true
        while (true) {
            if (b) {
                oddp.next = p
                oddp = p
            } else {
                evenp.next = p
                evenp = p
            }
            p = p.next ?: break
            b = !b
        }
        oddp.next = even.next
        evenp.next = null
        return odd.next
    }
}