class Solution {
    fun maxProduct(nums: IntArray): Int {
        
        var pre = 1 
        var suf = 1
        val n = nums.size
        var max = Integer.MIN_VALUE
        for(i in nums.indices) {

            if(pre == 0) pre = 1 
            if(suf == 0) suf = 1 

            pre = pre * nums[i]
            suf = suf * nums[n - i - 1]

            max = maxOf(max,pre,suf) 
            
        }

        return max
    }
}