class MedianFinder() {

    val maxHeap = PriorityQueue<Int>(compareByDescending{it})
    val minHeap = PriorityQueue<Int>()

    fun addNum(num: Int) {
        maxHeap.add(num)

        // check if every element in max heap is less than min heap

        if(!(maxHeap.isEmpty()) && !(minHeap.isEmpty()) &&  maxHeap.peek() > minHeap.peek() ) {
            val item = maxHeap.poll()
            minHeap.add(item)
        }

        if(maxHeap.size > minHeap.size + 1) {
            val item = maxHeap.poll()
            minHeap.add(item)
        }

        if(minHeap.size > maxHeap.size + 1 ) {
            val item = minHeap.poll()
            maxHeap.add(item)
        }
    }

    fun findMedian(): Double {
        
        return if(maxHeap.size > minHeap.size) {
            maxHeap.peek().toDouble()
        } else if(minHeap.size > maxHeap.size) {
            minHeap.peek().toDouble()
        } else {
            (maxHeap.peek() + minHeap.peek()).toDouble() / 2.0
        }
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */