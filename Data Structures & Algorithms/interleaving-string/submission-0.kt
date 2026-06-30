class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {

        val m = s1.length 
        val n = s2.length 
        val k = s3.length

        val dp = Array(m+1){ IntArray(n+1){-1}}

        if(m + n != k) return false

        fun interleave(i: Int, j: Int): Boolean {

            if (i == m && j == n) return true

            if(dp[i][j] != -1) return dp[i][j] == 1 

            var firstMatch = false
            var secondMatch = false

            if(i < m && s1[i] == s3[i+j]) {
                firstMatch = interleave(i+1,j)
            }

            if(j < n && s2[j] == s3[i+j]) {
                secondMatch = interleave(i,j+1)
            }

            dp[i][j] = if(firstMatch || secondMatch) 1 else 0

            return dp[i][j] == 1
        
        }

        return interleave(0,0)
        
    }
}