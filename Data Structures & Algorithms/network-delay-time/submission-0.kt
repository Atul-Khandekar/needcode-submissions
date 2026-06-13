class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {

        val edges = HashMap<Int,MutableList<Pair<Int,Int>>>()

        for((source, destination, weight) in times) {
            if(edges[source]==null) {
                edges[source] = mutableListOf(Pair(destination,weight)) 
            } else {
                edges[source]?.add(Pair(destination,weight))
            }
        }

        var time = 0
        val visit = mutableSetOf<Int>()
        val q = PriorityQueue<Pair<Int,Int>>(compareBy{it.second})
        q.add(Pair(k,0))
        
        while(!(q.isEmpty())) {
            val (node,weight) = q.poll()
            if(visit.contains(node)) continue 

            visit.add(node)
            time = weight

            if (visit.size == n) return time

            for( pair in edges[node]?:continue ) {
                val (node2,weight2) = pair
                if( !(visit.contains(node2))) {
                    q.add(Pair(node2, weight + weight2))
                }
            }

        }

        
        return if(visit.size == n) time else -1
    }
}