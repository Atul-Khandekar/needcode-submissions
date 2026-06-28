class Solution {
    fun change(amount: Int, coins: IntArray): Int {

        val dp = Array(coins.size){IntArray(amount+1){-1}}
        
        fun dfs(i: Int, target: Int): Int {

            if(target == 0) return 1
            if(target < 0 ) return 0 
            if(i >= coins.size) return 0 

            if(dp[i][target] != -1) return dp[i][target] 

            val take = dfs(i,target - coins[i])

            val notTake =  dfs(i+1,target)

            dp[i][target] = take + notTake

            return dp[i][target]
        }
        
        return dfs(0,amount)
    }
}