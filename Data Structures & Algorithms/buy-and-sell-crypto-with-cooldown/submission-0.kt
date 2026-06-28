class Solution {
    fun maxProfit(prices: IntArray): Int {

        if(prices.size==1) return 0 

        val n = prices.size
        val map = HashMap<Pair<Int,Boolean>,Int>()

        fun dfs(i: Int, buying: Boolean): Int {

            if(i >= n) return 0

            if(map[Pair(i,buying)]!=null) return map[Pair(i,buying)]!!

            val cooldown = dfs(i+1,buying)

            if(buying) {
                val buy = dfs(i+1,!buying) - prices[i]
                map[Pair(i,buying)] = Math.max(buy,cooldown)
            } else {
                val sell = dfs(i+2,!buying) + prices[i]
                map[Pair(i,buying)] = Math.max(sell,cooldown)
            }

            return map[Pair(i,buying)]!!
        }


        return dfs(0,true)

        
    }
}