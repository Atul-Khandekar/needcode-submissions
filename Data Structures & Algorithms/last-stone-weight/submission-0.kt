class Solution {
    fun lastStoneWeight(stones: IntArray): Int {

        if(stones.size==1) return stones[0]
        
        val maxHeap = PriorityQueue<Int>(compareByDescending{it}) 
        maxHeap.addAll(stones.toList())

        while(maxHeap.size > 1) {
            val first = maxHeap.poll()
            val second = maxHeap.poll()

            if(first!=second) {
                maxHeap.add(Math.abs(first-second))
            }
        }

        if(maxHeap.size==1) return maxHeap.peek() else return 0 
    }
}