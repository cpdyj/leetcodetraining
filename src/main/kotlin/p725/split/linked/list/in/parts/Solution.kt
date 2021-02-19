package p725.split.linked.list.`in`.parts

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun splitListToParts(root: ListNode?, k: Int): Array<ListNode?> {
        var len = 0
        var tail = root ?: return arrayOfNulls(k)
        while (true) {
            len++
            tail = tail.next ?: break
        }
        /////////
        val h = ListNode(Int.MIN_VALUE)
        h.next = root
        val mod = len % k
        return Array(k) {
            val s = len / k + if (it < mod) 1 else 0
            val newH = h.next
            var p = h
            repeat(s) {
                p = p.next!!
            }
            h.next = p.next
            p.next = null
            newH
        }
    }
}