package p114.flatten.binary.tree.to.linked.list

class Solution {
    fun flatten(root: TreeNode?): Unit {
        var p = root ?: return
//        var cur: TreeNode
        while (true) {
            if (p.left == null) {
                p = p.right ?: return
            } else {
                if (p.right == null) {
                    p.right = p.left
                    p.left = null
                    p = p.right ?: return
                } else {
                    var q = p.left!!
                    while (true) {
                        q = q.right ?: break
                    }
                    q.right = p.right
                    p.right = p.left
                    p.left = null
                }
            }
        }
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
