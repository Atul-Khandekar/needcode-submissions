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
    fun maxDepth(root: TreeNode?): Int {

        if(root==null) return 0
        val leftMaxDepth = 1+ maxDepth(root.left)
        val rightMaxDepth = 1+maxDepth(root.right)

        return if(leftMaxDepth>rightMaxDepth) leftMaxDepth else rightMaxDepth
    }
}