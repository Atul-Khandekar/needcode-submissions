class Solution {
    fun minDistance(word1: String, word2: String): Int {

        val m = word1.length 
        val n = word2.length

        val dp = Array(m+1){IntArray(n+1){0}}

        for(j in 0 .. n) {
            dp[m][j] = n - j
        }

        for(i in 0 .. m) {
            dp[i][n] = m - i
        }
        

        for(i in m - 1 downTo 0 ) {
            for(j in n-1 downTo 0) {
                if(word1[i] == word2[j]) {
                    dp[i][j] = dp[i+1][j+1]
                } else {
                    dp[i][j] = 1 + minOf(dp[i+1][j],dp[i][j+1],dp[i+1][j+1])
                }
            }
        }

        return dp[0][0]
        
    }
}