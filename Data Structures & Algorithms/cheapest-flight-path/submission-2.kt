class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        
        val adj = Array(n){ mutableListOf<Pair<Int,Int>>() }

        for( (from,to,price) in flights) {
            adj[from].add(Pair(price,to))
        }

        var count = k 
        var minCost = Int.MAX_VALUE

        //memoization 
        val memo = Array(n) { IntArray(k + 2) { Int.MAX_VALUE } }

        fun dfs(node: Int, count: Int, price: Int) {

            if(price >= minCost) return

            if(node == dst) {
                minCost = Math.min(minCost,price)
                return
            }

            if(count == - 1) {
              return
            }

            if(memo[node][count] <= price) return 
            memo[node][count] = price

            for( (p,d) in adj[node]) {
                dfs(d, count - 1, price + p)
            }

        }

        dfs(src,k,0)

        return if(minCost == Int.MAX_VALUE) return - 1 else minCost        
    }
}