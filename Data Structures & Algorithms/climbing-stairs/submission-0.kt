class Solution {
    fun climbStairs(n: Int): Int {
        val memo = IntArray(n + 1) { 0 }
        return totalWays(n, memo)
    }

    private fun totalWays(n: Int, memo: IntArray): Int {
        if (n <= 1) return 1
        if (memo[n] != 0) return memo[n]
        
        memo[n] = totalWays(n - 1, memo) + totalWays(n - 2, memo)
        return memo[n]
    }
}