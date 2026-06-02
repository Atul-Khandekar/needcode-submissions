class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        
        val maxHeap = PriorityQueue<IntArray>(compareBy{ it[0]*it[0] + it[1]*it[1] })
        maxHeap.addAll(points.toList())
        val result = mutableListOf<IntArray>()

        var count = k
        while(count>0) {
            result.add(maxHeap.poll())
            count--
        }

        return result.toTypedArray()
    }
}