class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
       
       val result = mutableListOf<List<Int>>()

       val subset = mutableListOf<Int>()

       fun dfs(i:Int) {
        
        if(i>=nums.size)  {
            val new = subset.toList()
            result.add(new)
            return
        }

        //take element 
        subset.add(nums[i])
        dfs(i+1)

        //not take element
        subset.removeLast()
        dfs(i+1)
       
       }

        dfs(0)

        return result
    }
}
