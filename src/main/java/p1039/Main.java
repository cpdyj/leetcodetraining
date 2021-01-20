package p1039;

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        LinkedList<TreeNode> q = new LinkedList<>();
        LinkedList<TreeNode> p = new LinkedList<>();
        TreeNode pt = original;
        TreeNode qt = cloned;
        while (pt != null) {
            if (pt == target) {
                return qt;
            }
            if (pt.left != null) {
                p.add(pt.left);
                q.add(qt.left);
            }
            if (pt.right != null) {
                p.add(pt.right);
                q.add(qt.right);
            }
            pt = p.pollFirst();
            qt = q.pollFirst();
        }
        return null;
    }
}