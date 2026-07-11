class Solution {
    fun minInterval(intervals: Array<IntArray>, queries: IntArray): IntArray {

        intervals.sortBy{it[0]}
        val res = IntArray(queries.size)
        
        val indexedQueries = queries.withIndex().toList().sortedBy{it.value}

        val minHeap = PriorityQueue<Pair<Int, Int>> { a, b -> a.first.compareTo(b.first) }

        var i = 0

        for(indexQuery in indexedQueries) {
            val ogIndex = indexQuery.index
            val qVal = indexQuery.value

            while (i < intervals.size && intervals[i][0] <= qVal) {
                val start = intervals[i][0]
                val end = intervals[i][1]
                val size = end - start + 1
                
                minHeap.offer(Pair(size, end))
                i++ 
            }

            while (!minHeap.isEmpty() && minHeap.peek().second < qVal) {
                minHeap.poll()
            }

            if (minHeap.isEmpty()) {
                res[ogIndex] = -1
            } else {
                res[ogIndex] = minHeap.peek().first
            }
        }

        return res

    }
}