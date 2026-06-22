class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {

        val dp = IntArray(amount + 1) {amount+1}
        dp[0] = 0

        for( i in 1 until  amount + 1) {
            for( c  in coins) {
                if(i-c >=0) {
                    dp[i] = Math.min(dp[i],1 + dp[i-c])
                }
            }
        }

        return if(dp[amount] == amount+1) -1 else dp[amount]
        
    }
}