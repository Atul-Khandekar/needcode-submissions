class Solution {
    fun canPartition(nums: IntArray): Boolean {

        val sum = nums.sum()
        val n = nums.size
        if(sum%2 != 0 ) return false 
        
        val half = sum/2 
        var res = 0 
        var ans = false

        val dp = Array(n+1){ IntArray(half + 1) { - 1 } }

        for(i in 0..n) {
            dp[i][0] = 1
        }

        fun dfs(i:Int, target: Int): Boolean {

            if(i>=n || target < 0) return false

            if(dp[i][target] != -1 ) {
                return (dp[i][target] == 1)
            }

            val take = dfs(i+1, target - nums[i])

            val notTake = dfs(i+1,target) 

            dp[i][target] = if(take || notTake) 1 else 0 

            return dp[i][target] == 1
        }

        return dfs(0,half)

    }
}