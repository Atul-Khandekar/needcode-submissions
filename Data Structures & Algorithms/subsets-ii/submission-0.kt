class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {

        nums.sort()
        val res = mutableListOf<List<Int>>()
        val sub = mutableListOf<Int>()

        fun backtrack(k: Int) {
            if(k==nums.size) {
                val new = sub.toList()
                res.add(new)
                return
            }

            sub.add(nums[k])
            backtrack(k+1)

            sub.removeLast()

            var i = k
            while( (i+1)< nums.size && nums[i]==nums[i+1]) {
                i++
            }

            backtrack(i+1)
        }

        backtrack(0)

        return res.toList()
    }
}
