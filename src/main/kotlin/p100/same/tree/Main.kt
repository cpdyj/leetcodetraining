package p100.same.tree

import java.util.*

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        val l1 = arrayOfNulls<TreeNode>(32)
        val l2 = arrayOfNulls<TreeNode>(32)
        l1[0] = p
        l2[0] = q
        var pos = 1
        while (pos != 0) {
            val p = l1[pos]
            val q = l2[pos]
            if (p?.`val` != q?.`val`){
                return false
            }
            
        }
        return true
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
