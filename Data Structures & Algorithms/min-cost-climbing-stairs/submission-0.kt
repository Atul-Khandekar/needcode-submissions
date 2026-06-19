class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {

        val n = cost.size
        val dp = IntArray(n){0}
        for(i in cost.indices.reversed()) {
            if(i == n-1) {
                dp[i] = cost[i]
                continue
            }
            if(i == n - 2) {
                dp[i] = Math.min(cost[i],cost[i]+dp[i+1])
                continue
            }

            dp[i] = cost[i] + Math.min(dp[i+1],dp[i+2])
        }

        return Math.min(dp[0],dp[1])
    }
}