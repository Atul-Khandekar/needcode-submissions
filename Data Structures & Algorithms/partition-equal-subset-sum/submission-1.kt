class Solution {
    fun canPartition(nums: IntArray): Boolean {

        val sum = nums.sum()
        val n = nums.size
        if(sum%2 != 0 ) return false 
        
        val half = sum/2 

        val dp = BooleanArray(half + 1) { false }

        dp[0] = true

        for(num in nums) {

            for(j in half downTo num) {
                if(dp[j-num]) {
                    dp[j] = true
                }
            }
        }

        return dp[half]
    }
}