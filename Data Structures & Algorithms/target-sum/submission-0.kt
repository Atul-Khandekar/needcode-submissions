class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {

        fun dfs(i: Int,sum: Int): Int {
            
            if(i >= nums.size) {
                return if(sum==0) 1 else 0
            }

            val plus = dfs(i+1,sum + nums[i])

            val minus = dfs(i+1,sum-nums[i])

            return plus + minus
        }

        return dfs(0,target)
        
    }
}