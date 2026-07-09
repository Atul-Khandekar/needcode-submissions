class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        
        if (intervals.size <= 1) return intervals

        intervals.sortBy { it[0] }

        val res = mutableListOf<IntArray>()

        var currentInterval = intervals[0]
        res.add(currentInterval)

        for (interval in intervals) {
            val currentEnd = currentInterval[1]
            val nextStart = interval[0]
            val nextEnd = interval[1]

            if (currentEnd >= nextStart) {
                currentInterval[1] = maxOf(currentEnd, nextEnd)
            } else {
                currentInterval = interval
                res.add(currentInterval)
            }
        }

        return res.toTypedArray()
    }
}