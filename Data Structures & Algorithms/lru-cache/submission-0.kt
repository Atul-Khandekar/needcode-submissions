class LRUCache(val capacity: Int) {

    val map = HashMap<Int,Node?>()
    val left = Node(0,0)
    val right = Node(0,0)
    
    init {
        left.next = right 
        right.prev = left  
    }

    fun removeNode(node: Node?) {
        val next = node?.next 
        val prev = node?.prev

        next?.prev = prev 
        prev?.next = next
    }

    fun insertNode(node: Node?) {
        val prev = right?.prev 
        right?.prev = node 
        prev?.next = node 

        node?.next = right 
        node?.prev = prev

    }

    fun get(key: Int): Int {
        return if(map[key]==null) {
            -1 
        } else {
            //i am getting the value so change it to the most recent used value in the doubly linked list 
            val node = map[key]
            removeNode(node)
            insertNode(node)
            node?.value!!
        }

      
    }

    fun put(key: Int, value: Int) {
        if(map.containsKey(key)) {
            val node = map[key]
            node?.value = value
            removeNode(map[key])
            insertNode(map[key])
            return
        }

        val newNode = Node(key, value)
        map[key] = newNode
        insertNode(newNode)

        if(map.size > capacity) {
            val lruNode = left?.next
            removeNode(lruNode)
            map.remove(lruNode?.key)
        }

    }

}

class Node(var key:Int,var value: Int) {
    var prev: Node? = null 
    var next: Node? = null 
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */