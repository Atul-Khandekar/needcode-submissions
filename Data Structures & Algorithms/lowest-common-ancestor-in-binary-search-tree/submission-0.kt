class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return null

        val curr = root.`val`
        val pVal = p?.`val` ?: 0
        val qVal = q?.`val` ?: 0

        // If both p and q are smaller than root, LCA is in the left subtree
        return if (curr > pVal && curr > qVal) {
            lowestCommonAncestor(root.left, p, q)
        } 
        // If both p and q are larger than root, LCA is in the right subtree
        else if (curr < pVal && curr < qVal) {
            lowestCommonAncestor(root.right, p, q)
        } 
        // We found the split point (or one of the nodes is the root itself)
        else {
            root
        }
    }
}