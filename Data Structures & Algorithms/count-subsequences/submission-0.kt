class Solution {
    fun numDistinct(s: String, t: String): Int {
        if(s.length < t.length) return 0 

        val dp = Array(s.length){IntArray(t.length){-1}}

        fun dfs(i: Int,j: Int): Int {

            if(j >= t.length) return 1

            if(i >= s.length) return 0 

            if(dp[i][j] != -1) return dp[i][j]

            dp[i][j] =  if(s[i] == t[j]) {
                dfs(i+1,j+1) + dfs(i+1,j)
            } else {
                dfs(i+1,j)
            }

            return dp[i][j]
        }

        return dfs(0,0)

    }
}