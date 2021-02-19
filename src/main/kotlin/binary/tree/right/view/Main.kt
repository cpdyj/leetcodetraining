package binary.tree.right.view

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
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null)
            return emptyList()
        val list = ArrayList<Int>(100)
        todo(root, 0, list)
        return list
    }

    fun todo(node: TreeNode, depth: Int, list: ArrayList<Int>) {
        if (list.lastIndex < depth) {
            list.add(node.`val`)
        }
        node.right?.let { todo(it, depth + 1, list) }
        node.left?.let { todo(it, depth + 1, list) }
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

