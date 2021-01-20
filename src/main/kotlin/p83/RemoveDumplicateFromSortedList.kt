package p83

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
        var p = head
        while (p!=null){
            val n = p.next?:break
            if (p.`val` == n.`val`){
                p.next = n.next
            }else{
                p = p.next
            }
        }
        return head
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}