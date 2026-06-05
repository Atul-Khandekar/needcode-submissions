class Solution {
    fun combinationSum2(nums: IntArray, target: Int): List<List<Int>> {

        nums.sort()
        val result = mutableListOf<List<Int>>()
        val sub = mutableListOf<Int>()

        fun backtrack(pos:Int, sub: MutableList<Int>, target: Int) {

                if(target == 0) {
                    val new = sub.toList()
                    result.add(new)
                    return
                }

            if(target <= 0) {
                return 
            }

            var prev = -1 

            for(i in pos until nums.size) {
                if(nums[i] == prev) {continue}

                sub.add(nums[i])
                backtrack(i+1, sub, target- nums[i])
                sub.removeLast()

                prev = nums[i]
            }

        }

        backtrack(0,mutableListOf(),target)

        return result

    }
}
