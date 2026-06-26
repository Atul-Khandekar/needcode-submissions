class Solution {
    fun lengthOfLIS(nums: IntArray): Int {

        val n = nums.size
        val res = IntArray(n+1){1}

        for(i in nums.indices.reversed()) {
            for(j in (i+1) until n) {
                if(nums[i] < nums[j]) {
                    res[i] = Math.max(res[i], 1+res[j])
                }
            }
        }
        
        return res.max()
    }
}