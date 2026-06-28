class Solution {
    fun uniquePaths(m: Int, n: Int): Int {

        if(m==1|| n==1) return 1

        val dp = Array(m){IntArray(n)}

        dp[m-2][n-1] = 1 
        dp[m-1][n-2] = 1
        dp[m-1][n-1] = 0

        for(i in m-1 downTo 0 ) {

            for( j in n-1 downTo 0 ) {
                
                if( i + 1  <= m - 1 && j <= n-1) {
                    dp[i][j] += dp[i+1][j]
                }

                if(i <= m-1 && j+1 <= n-1) {
                    dp[i][j] += dp[i][j+1]
                }
               

            }
        }

        return dp[0][0]
    }
}