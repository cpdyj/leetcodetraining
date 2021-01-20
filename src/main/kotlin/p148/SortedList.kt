package p148

class Solution {
    fun sortList(head: ListNode?): ListNode? {
        var p = head


        TODO()
    }

    fun merge(head: ListNode, size: Int): ListNode {
        var p: ListNode? = head
        var q = p
        for (i in 0 until size / 2) {
            q = q?.next ?: break
        }
        val head = ListNode(0)
        var t = head
        while (q != null || p != null) {
            if (q == null || (p != null && p.`val` < q.`val`)){
                t.next = p!!
                t=p
            }else{
                t.next = q
                t = q
            }
        }
        return head.next!!
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}