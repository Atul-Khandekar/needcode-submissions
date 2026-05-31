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

    var maxi = 0 
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        height(root,maxi)
        return maxi
    }

    fun height(root:TreeNode?, max:Int ): Int {
        if(root==null) return 0

        val lh = height(root.left,max)
        val rh = height(root.right,max)

        maxi = Math.max(maxi,lh+rh)

        return 1+ Math.max(lh,rh)
    }
}