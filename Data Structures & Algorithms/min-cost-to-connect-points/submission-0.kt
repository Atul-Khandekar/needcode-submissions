class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {

        val n = points.size
        if(n == 1)  return 0 
        
        val visited = BooleanArray(n)
        var result = 0 
        var edgeUsed = 0 

        val q = PriorityQueue<Pair<Int,Int>>(compareBy{ it.first })
        
        q.add(Pair(0,0))

        while(!(q.isEmpty()) && edgeUsed < n ) {
            val curr = q.poll()
            val weight = curr.first
            val u = curr.second

            if(visited[u]) continue 

            result += weight
            visited[u] = true 
            edgeUsed++

            for( v in 0 until n ) {
                if(!visited[v])  {
                    val distance = abs(points[u][0] - points[v][0]) + abs(points[u][1] - points[v][1])
                    q.add(Pair(distance, v))
                }
            }
        }

        return result
        
    }
}