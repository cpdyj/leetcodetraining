package p61.rotate

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        val head = head?:return null
        var p = head
        var q = head.next?:return head
        var (size,tail) = count(head)
        val k = k % size
        repeat(k){
            tail.next = p
            tail = p
            p = q
            q = p.next!!
            tail.next = null
        }
        return p
    }

    tailrec fun count(head: ListNode,s:Int = 1): Pair<Int, ListNode> {
        val t = head.next?:return s to head
        return count(t,s+1)
    }
}

