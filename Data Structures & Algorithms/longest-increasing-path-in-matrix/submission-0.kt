class Solution {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {

        val m = matrix.size 
        val n = matrix[0].size 

        val dp = Array(m+1){IntArray(n+1){-1}}

        var ans = Int.MIN_VALUE
        
        fun dfs(i:Int, j: Int, prev: Int): Int {

            if(i < 0 || j < 0 || i >= m || j >= n || matrix[i][j] <= prev) return 0

            if(dp[i][j] != -1) return dp[i][j]

            val down = 1 + dfs(i+1,j,matrix[i][j])
            val up = 1 + dfs(i-1,j,matrix[i][j])
            val right = 1 + dfs(i,j+1,matrix[i][j])
            val left = 1 + dfs(i,j-1,matrix[i][j])

            dp[i][j] =  maxOf(down,up,right,left)

            return dp[i][j]
        }

        for(i in matrix.indices) {
            for(j in matrix[i].indices) {
                ans = maxOf(ans,dfs(i,j,-1))
            }
        }


        return ans
    }
}