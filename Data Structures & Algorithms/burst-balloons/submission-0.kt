class Solution {
    fun maxCoins(nums: IntArray): Int {

        var arr = intArrayOf(1, *nums, 1)

        val dp = Array(nums.size+2){IntArray(nums.size + 2){ -1} }


        fun dfs(l: Int, r: Int): Int {
            if(l > r) return 0

            if(dp[l][r] != -1) return dp[l][r]

            for(i in l..r) {
                var coins = arr[l-1] * arr[i] * arr[r+1]
                coins += dfs(l,i-1) + dfs(i+1,r)
                dp[l][r] = maxOf(dp[l][r],coins)
            }

            return dp[l][r]
        }
        
        return dfs(1,nums.size)
    }
}