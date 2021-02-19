package p86.partition.list

class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        var p = head ?: return null
        val t1 = ListNode(0)
        val t2 = ListNode(0)
        var p1 = t1
        var p2 = t2
        while (true) {
            if (p.`val` < x) {
                p1.next = p
                p1 = p
            } else {
                p2.next = p
                p2 = p
            }
            p = p.next ?: break
        }
        p2.next = null
        p1.next = t2.next
        return t1.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}