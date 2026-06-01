class KthLargest(val k: Int, val nums: IntArray) {

    val queue = PriorityQueue(nums.toList())
    init {

        while(queue.size>k) {
            queue.remove()
        }
    }


    fun add(`val`: Int): Int {
        
        queue.add(`val`) 
        if(queue.size>k) {
            queue.remove()
        }

        return queue.first()
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */