package p82

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val head = ListNode(0).apply { next = head }
        var p = head
        while (true) {
            val n = p.next ?: break
            val nn = n.next ?: break
            if (n.`val` == nn.`val`) {
                var ptr: ListNode? = nn
                while (ptr != null && ptr.`val` == nn.`val`) {
                    ptr = ptr.next
                }
                p.next = ptr
            }else{
                p = p.next?:break
            }
        }
        return head.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}