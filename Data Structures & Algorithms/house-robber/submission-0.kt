class Solution {
    fun rob(nums: IntArray): Int {

        if(nums.size == 1) return nums[0]

        if(nums.size == 2) return Math.max(nums[0],nums[1])
        
        for( i in nums.indices.reversed()) {
            if(i == nums.size - 1 || i == nums.size - 2 ) continue

            if(i == nums.size - 3) {
                nums[i] = nums[i] + nums[i+2] 
                continue 
                }
            nums[i] = nums[i] + Math.max(nums[i+2], nums[i+3])
        }

        return Math.max(nums[0],nums[1])
    }
}