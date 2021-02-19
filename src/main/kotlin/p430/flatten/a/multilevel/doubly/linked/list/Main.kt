package p430.flatten.a.multilevel.doubly.linked.list

class Node(var `val`: Int) {
    var prev: Node? = null
    var next: Node? = null
    var child: Node? = null
}


class Solution {
    fun flatten(root: Node?): Node? {
        a(root ?: return null)
        return root
    }

    fun a(root: Node): Node {
        var p = root
        while (true){
            val c = p.child
            if (c!==null){
                val n = p.next
                c.prev = p
                p.next = c
                val r = a(c)
                p.child = null
                r.next = n
                n?.prev=r
                p = r
            }else{
                p=p.next?:return p
            }
        }
    }
}