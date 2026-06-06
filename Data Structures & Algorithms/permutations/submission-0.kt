class Solution {
    fun permute(nums: IntArray): List<List<Int>> {

        val res = mutableListOf<List<Int>>()
        val subset = mutableSetOf<Int>()

        fun backtrack() {
            if(subset.size == nums.size) {
                val new = subset.toList()
                res.add(new)
                return 
            }

            for(i in nums.indices) {
                if(!subset.contains(nums[i])) {
                    subset.add(nums[i])
                    backtrack()
                    subset.remove(nums[i])
                }
            }
        }

        backtrack()

        return res
        
    }
}