/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {

        if (intervals.isEmpty()) return true
        
        val sortedIntervals = intervals.sortedBy { it.start }

        var currentEnd = sortedIntervals[0].end

        for(i in 1 until sortedIntervals.size) {
            if(sortedIntervals[i].start < currentEnd) {
                return false
            } else {
                currentEnd = sortedIntervals[i].end
            }
        }

        return true
    }
}
