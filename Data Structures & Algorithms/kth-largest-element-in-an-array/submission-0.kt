
class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {

        val minHeap = PriorityQueue<Int>(compareByDescending{it})
        val kth = nums.size - k + 1
        for(num in nums) {
            if(minHeap.size<kth) {
                minHeap.add(num)
            } else {
                if(num < minHeap.peek()){
                    minHeap.add(num)
                    val max = minHeap.max()
                    minHeap.remove(max)
                }
            }
        }

        return minHeap.peek()
    }
}
