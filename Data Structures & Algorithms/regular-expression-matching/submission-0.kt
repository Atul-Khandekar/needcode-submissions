class Solution {
    fun isMatch(s: String, p: String): Boolean {
        
        val dp = Array(s.length + 1){IntArray(p.length + 1) {-1}}

        fun dfs(i: Int, j: Int): Boolean {

            if (j >= p.length) return i == s.length

            if(dp[i][j] != -1) return dp[i][j]==1

            val match = i < s.length &&  (s[i] == p[j] || p[j] == '.')

            if(j + 1 < p.length && p[j+1] == '*') {

                dp[i][j] = if(dfs(i,j+2) || (match && dfs(i+1,j))) 1 else 0
                return dp[i][j] == 1
            }

            if(match){
                dp[i][j] = if(dfs(i+1,j+1)) 1 else 0
                return dp[i][j] == 1
            } 

            dp[i][j] = 0
            return false
        }

        return dfs(0,0)
    }
}