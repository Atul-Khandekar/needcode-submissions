class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {

        val result = mutableListOf<List<Int>>()
        val sub = mutableListOf<Int>()

        fun dfs(i:Int, sub: MutableList<Int>, total: Int) {

            if(total == target) {
                val new = sub.toList()
                result.add(new)
                return
            }

            if(i>=nums.size || total > target) {
                return 
            }

            //include the candidate 
            sub.add(nums[i])
            dfs(i,sub,total + nums[i])

            sub.removeLast()
            dfs(i+1,sub,total)
        }

        dfs(0,mutableListOf(),0)

        return result
    }

    
}
