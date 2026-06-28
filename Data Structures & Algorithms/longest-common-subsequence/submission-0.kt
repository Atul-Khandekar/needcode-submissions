class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {

        val m = text1.length 
        val n = text2.length 

        val dp = Array(m + 1) { IntArray(n + 1) }
        for (i in m - 1 downTo 0) {
                for (j in n - 1 downTo 0) {
                    if (text1[i] == text2[j]) {

                        dp[i][j] = 1 + dp[i + 1][j + 1]
                    } else {

                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1])
                    }
                }
            }


            return dp[0][0]
        
    }
}