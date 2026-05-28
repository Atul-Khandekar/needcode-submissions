/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {

        val map = HashMap<Node?,Node?>()
        map[null] = null 

        var curr = head 
        
        while(curr != null ) {
            val newNode =  Node(curr.`val`)
            map[curr] = newNode
            curr = curr?.next
        }

        curr = head 
        while(curr!=null) {
            val copy = map[curr]
            copy?.next = map[curr?.next]
            copy?.random = map[curr?.random]
            curr = curr?.next
        }

       return  map[head]
    }
}
