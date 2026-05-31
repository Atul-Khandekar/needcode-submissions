/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

class Solution {
    val map = HashMap<Int,Node?>()
    fun cloneGraph(node: Node?): Node? {

        if(node==null){return null}
        
         if(map.contains(node?.`val`)==true) {
            return map[node?.`val`]
        }

        val newNode = Node(node!!.`val`)
        map.put(node!!.`val`,newNode)
        for(n in node.neighbors) {
            newNode?.neighbors?.add(cloneGraph(n))
        }

        return newNode
    }
}