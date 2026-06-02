class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {

        val map = HashMap<Char,Int>()
        for(char in tasks) {
            map[char] = (map[char]?:0) + 1
        }

        val maxHeap = PriorityQueue<Int>(compareByDescending{it})
        for((_,value) in map) {
            maxHeap.add(value)
        }

        var time = 0 
        //count and time when it will be available
        var q = ArrayDeque<Pair<Int,Int>>()
        
        while((!maxHeap.isEmpty()) || !(q.isEmpty())) {
            time++

            if(!maxHeap.isEmpty()) {
                val count = maxHeap.poll() - 1 

                if(count>0) {
                    q.addLast(Pair(count,time+n))
                }
            }

            if(!q.isEmpty() && q.first().second == time) {
                val element = q.removeFirst().first
                maxHeap.add(element)
            }
        }

        return time
    }
}
