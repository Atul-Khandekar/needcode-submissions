class Solution {
    fun maxSubArray(nums: IntArray): Int {
        if(nums.size == 0 ) return 0 
        var sum = 0 
        var maxSum = nums[0]
        for(num in nums) {
            if(sum<0) {
                sum = 0 
            } 
            sum += num
            maxSum = Math.max(sum,maxSum)
        }

        return maxSum
    }
}
